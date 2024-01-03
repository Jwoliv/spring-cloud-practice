package com.example.springmiddleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class SpringMiddleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMiddleServiceApplication.class, args);
    }

}
