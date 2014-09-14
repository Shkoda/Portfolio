package com.pelican.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by Nightingale on 13.08.2014.
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select login,password_hash, enabled from users.auth where login=?")
                .authoritiesByUsernameQuery(
                        "SELECT  A.login, R.role FROM " +
                                "(SELECT login, role_id FROM users.auth WHERE login = ?) " +
                                "AS A LEFT JOIN " +
                                "(SELECT id, role FROM users.roles) " +
                                "AS R ON (A.role_id = R.id)");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/protected/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
                .antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')")
                .antMatchers("/user/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERADMIN')")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/user/dashboard", false);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public RoleHierarchy roleHierarchy() {
//        Loggers.debugLogger.debug("call roleHierarchy()");
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        roleHierarchy.setHierarchy(
//                "SUPERADMIN > ADMIN " +
//                "ADMIN > USER  " +
//                "USER > GUEST");
//        return roleHierarchy;
//    }
//
//    @Bean
//    public RoleVoter roleVoter() {
//        Loggers.debugLogger.debug("call roleVoter()");
//        return new RoleHierarchyVoter(roleHierarchy());
//    }


}