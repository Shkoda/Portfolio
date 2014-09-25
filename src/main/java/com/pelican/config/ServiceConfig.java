package com.pelican.config;

import com.pelican.service.LoginService;
import com.pelican.service.RepoLoginService;
import com.pelican.service.TaskService;
import com.pelican.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Nightingale on 10.09.2014.
 */
@Configuration
public class ServiceConfig {
    @Bean
    @Qualifier(value = "loginService")
    public LoginService loginService() {
        return new RepoLoginService();
    }
    @Bean
    @Qualifier(value = "taskService")
    public TaskService taskService() {
        return new TaskServiceImpl();
    }

}
