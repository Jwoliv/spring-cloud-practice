package com.example.springmiddleservice.service;

import com.example.springmiddleservice.openfeign.CoreClient;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CoreService {
    @Setter(onMethod = @__(@Autowired))
    private CoreClient coreClient;

    @Cacheable(key = "#name", value = "spring-core")
    public String getGreet(String name) {
        log.info("Greet method use again");
        return coreClient.getGreet(name).getBody();
    }

    @Cacheable(key = "#v1.toString().concat('_').concat(#v2.toString())", value = "spring-core")
    public Long getAdditionTwoValues(Long v1, Long v2) {
        return coreClient.getAdditionTwoValues(v1, v2).getBody();
    }
}
