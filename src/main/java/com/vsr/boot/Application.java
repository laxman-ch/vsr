package com.vsr.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.vsr", "com.vsr.dao"})
@EnableJpaRepositories(basePackages = {"com.vsr.dao"})
@EntityScan(basePackages = {"com.vsr"})
@Import({RepositoryConfiguration.class})
@EnableAutoConfiguration
@PropertySource("application.properties")
public class Application {
    private static Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws Exception {
        log.info("++++++++++++++++++++++++++++START++++++++++++++++++++++++++++");
//        Log4jConfigurer.initLogging("classpath:log4j.properties");
        SpringApplication.run(Application.class, args);
    }

}