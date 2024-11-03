package com.omsent.coreservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(CoreServiceStarterProperties.class)
public class CoreServiceStarterAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(CoreServiceStarterAutoConfiguration.class);

    @Autowired
    CoreServiceStarterProperties coreServiceStarterProperties;
    @Bean
    public UserManager userManager() {
        logger.info("UserManager bean start to create.");
        UserManager userManager = new UserManager();
        logger.info("CoreServiceStarterAutoConfiguration constructor. coreServiceStarterProperties={}",coreServiceStarterProperties);

        return userManager;
    }

    @Bean
    public HomeController homeController(){
        logger.info("HomeController bean start to create.");
        return new HomeController();
    }


}