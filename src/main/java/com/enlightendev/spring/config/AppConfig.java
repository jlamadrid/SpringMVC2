package com.enlightendev.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Juan on 3/26/14.
 */
@Configuration
@PropertySource({"classpath:config.properties"})
@ComponentScan(basePackages = {"com.enlightendev"})
public class AppConfig {

}
