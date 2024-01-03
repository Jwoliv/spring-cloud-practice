package com.example.springmiddleservice.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-core-service", url = "http://localhost:9001/core")
public interface CoreClient {
    @GetMapping("/greet")
    ResponseEntity<String> getGreet(@RequestParam("n") String name);

    @GetMapping("/addition")
    ResponseEntity<Long> getAdditionTwoValues(@RequestParam("v1") Long value1, @RequestParam("v2") Long value2);
}
