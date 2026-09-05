package com.vehiclesSystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.vehiclesSystem")
@PropertySource("classpath:application.properties")
public class Config {
}
