package com.pelican.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Nightingale on 13.08.2014.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.pelican.config", "com.pelican.controllers", "com.pelican.service", "com.pelican.repositories", "com.pelican.entity"})
//@Import({ AppSecurityConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(0);
        return viewResolver;
    }

    @Bean
    public ViewResolver alterViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".html");
        viewResolver.setOrder(1);
        return viewResolver;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*.css").addResourceLocations("/css/");
        registry.addResourceHandler("*.js").addResourceLocations("/js/");
        registry.addResourceHandler("*.eot").addResourceLocations("/font-awesome-4.1.0/fonts", "/fonts");
        registry.addResourceHandler("*.otf").addResourceLocations("/font-awesome-4.1.0/fonts", "/fonts");
        registry.addResourceHandler("*.svg").addResourceLocations("/font-awesome-4.1.0/fonts", "/fonts");
        registry.addResourceHandler("*.ttf").addResourceLocations("/font-awesome-4.1.0/fonts", "/fonts");
        registry.addResourceHandler("*.woff").addResourceLocations("/font-awesome-4.1.0/fonts", "/fonts");
        registry.addResourceHandler("*.less").addResourceLocations("/font-awesome-4.1.0/less","/less");
        registry.addResourceHandler("*.scss").addResourceLocations("/font-awesome-4.1.0/scss");

//        registry.addResourceHandler("*.png").addResourceLocations("/css/");
//        registry.addResourceHandler("*.jpg").addResourceLocations("/css/");
//        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}