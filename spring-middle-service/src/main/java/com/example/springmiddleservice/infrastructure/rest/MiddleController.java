package com.example.springmiddleservice.infrastructure.rest;

import com.example.springmiddleservice.dto.AdditionDto;
import com.example.springmiddleservice.exception.InvalidParamException;
import com.example.springmiddleservice.openfeign.CoreClient;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/middle")
public class MiddleController {
    @Setter(onMethod = @__(@Autowired))
    private CoreClient coreClient;


    @GetMapping("/greet")
    public ResponseEntity<String> greet(@RequestParam("name") String name) {
        String greetBodyOfCore = coreClient.getGreet(name).getBody();
        return ResponseEntity.ok("greetBodyOfCore: ".concat(Objects.requireNonNull(greetBodyOfCore)));
    }

    @GetMapping("/addition")
    public ResponseEntity<String> addition(@RequestBody AdditionDto additionDto) {
        if (Objects.isNull(additionDto.getV1()) || Objects.isNull(additionDto.getV2())) throw new InvalidParamException();
        Long additionResult = coreClient.getAdditionTwoValues(additionDto.getV1(), additionDto.getV2()).getBody();
        return ResponseEntity.ok("Result of the core service: ".concat(String.valueOf(additionResult)));
    }
}