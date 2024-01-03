package com.example.springcoreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreServiceApplication.class, args);
    }

}
