package com.example.springmiddleservice.config;

import brave.Tracing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Tracing tracing() {
        return Tracing.newBuilder().build();
    }
}

