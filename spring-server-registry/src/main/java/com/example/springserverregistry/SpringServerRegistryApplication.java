package com.example.springserverregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringServerRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringServerRegistryApplication.class, args);
    }

}
