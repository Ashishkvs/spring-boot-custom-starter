Create custom starter using start.spring.io and 
remove all plugin and application.properties file

Add file into resources >> META-INF >> spring >> org.springframework.boot.autoconfigure.AutoConfiguration.imports

mavenLocal() // needs to be added in gradle project to pick up locally

maven clean install

#References
https://docs.spring.io/spring-boot/reference/features/developing-auto-configuration.html#features.developing-auto-configuration.custom-starter
https://www.youtube.com/watch?v=9m1bC57oWrc