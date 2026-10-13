package com.piseth.springbeandemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
@ComponentScan(basePackages = "com.piseth.springbeandemo")
public class AppConfig {
    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
