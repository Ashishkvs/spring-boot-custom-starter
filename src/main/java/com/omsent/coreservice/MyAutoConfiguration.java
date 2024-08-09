package com.omsent.coreservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MyAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(MyAutoConfiguration.class);

    public MyAutoConfiguration() {
    }

    @Bean
    public UserManager userManager() {
        logger.info("UserManager bean start to create.");
        UserManager userManager = new UserManager();
        return userManager;
    }
}