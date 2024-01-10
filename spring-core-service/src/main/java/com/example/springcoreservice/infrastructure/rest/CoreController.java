package com.example.springcoreservice.infrastructure.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/core")
public class CoreController {
    private final static String HELLO = "Hello from core to ";

    @GetMapping("/greet")
    public ResponseEntity<String> getGreet(@RequestParam("n") String name) {
        return ResponseEntity.ok(HELLO.concat(Objects.isNull(name) ? "Someone" : name));
    }


    @GetMapping("/addition")
    public ResponseEntity<String> getAdditionTwoValues(
            @RequestParam(name = "v1") Long value1,
            @RequestParam(name = "v2") Long value2
    ) {
        if (Objects.isNull(value1) || Objects.isNull(value2)) return ResponseEntity.badRequest().body(String.format("Params is invalid: value1 = %d, value2 = %d", value1, value2));
        return ResponseEntity.status(200).body(String.valueOf(value1 + value2));
    }
}
