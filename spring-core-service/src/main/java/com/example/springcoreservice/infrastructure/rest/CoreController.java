package com.example.springcoreservice.infrastructure.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/core")
public class CoreController {
    private final static String HELLO = "Hello from core to ";

    @GetMapping("/greet")
    public ResponseEntity<String> getGreet(@RequestParam("n") String name) {
        return ResponseEntity.ok(HELLO.concat(Objects.isNull(name) ? "Someone" : name));
    }


    @GetMapping("/addition")
    public ResponseEntity<Long> getAdditionTwoValues(
            @RequestParam(name = "v1") Long value1,
            @RequestParam(name = "v2") Long value2
    ) {
        return ResponseEntity.status(200).body(value1 + value2);
    }

    private Boolean checkExistedValue(Long value1, Long value2) {
        return Objects.isNull(value1) || Objects.isNull(value2);
    }
}
