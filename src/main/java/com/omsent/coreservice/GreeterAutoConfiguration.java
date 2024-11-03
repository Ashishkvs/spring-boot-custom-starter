//package com.omsent.coreservice;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//
//@AutoConfiguration
//@ConditionalOnClass(Greeter.class)
//@EnableConfigurationProperties(GreeterProperties.class)
//public class GreeterAutoConfiguration {
//    private static final Logger logger = LoggerFactory.getLogger(GreeterAutoConfiguration.class);
//
//    @Autowired
//    GreeterProperties greeterProperties;
//    @Bean
//    @ConditionalOnMissingBean
//    public GreetingConfig greeterConfig() {
//
//        String userName = greeterProperties.getUserName() == null
//                ? System.getProperty("user.name")
//                : greeterProperties.getUserName();
//
//        // ..
//
//        GreetingConfig greetingConfig = new GreetingConfig();
//        greetingConfig.put(USER_NAME, userName);
//        // ...
//        return greetingConfig;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public Greeter greeter(GreetingConfig greetingConfig) {
//        return new Greeter(greetingConfig);
//    }
////    @Bean
////    public UserManager userManager() {
////        logger.info("UserManager bean start to create.");
////        UserManager userManager = new UserManager();
////        logger.info("CoreServiceStarterAutoConfiguration constructor. coreServiceStarterProperties={}",coreServiceStarterProperties);
////
////        return userManager;
////    }
//
//
//}