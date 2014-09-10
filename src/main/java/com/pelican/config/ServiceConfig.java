package com.pelican.config;

import com.pelican.service.LoginService;
import com.pelican.service.RepoLoginService;
import com.pelican.utils.Loggers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Nightingale on 10.09.2014.
 */
@Configuration
@ComponentScan({"com.pelican.service", "com.pelican.persistence.repository"})
public class ServiceConfig {
    @Bean
    @Qualifier(value = "loginService")
    public LoginService createLoginRepository(){
        Loggers.debugLogger.debug("creating login service...");
        return new RepoLoginService();
    }
}
