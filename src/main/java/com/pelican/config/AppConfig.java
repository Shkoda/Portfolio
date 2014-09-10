package com.pelican.config;

import com.pelican.utils.Loggers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Nightingale on 22.08.2014.
 */
@Configuration
@PropertySource(value = {"classpath:application.properties"})
@EnableScheduling
@EnableCaching
@ComponentScan({"com.pelican.config", "com.pelican.controllers", "com.pelican.service", "com.pelican.repositories"})
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        Loggers.debugLogger.debug("srart placeHolderConfigurer()");
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        Loggers.debugLogger.debug("done placeHolderConfigurer()");
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public CacheManager cacheManager() {
        Loggers.debugLogger.debug("start cacheManager()");
        ConcurrentMapCacheManager concurrentMapCacheManager = new ConcurrentMapCacheManager();
        Loggers.debugLogger.debug("done cacheManager()");
        return concurrentMapCacheManager;
    }


}
