package com.example.springmiddleservice.infrastructure.rest;

import com.example.springmiddleservice.dto.AdditionDto;
import com.example.springmiddleservice.exception.InvalidParamException;
import com.example.springmiddleservice.service.CoreService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/middle")
public class MiddleController {
    @Setter(onMethod = @__(@Autowired))
    private CoreService coreService;


    @GetMapping("/greet")
    public ResponseEntity<String> greet(@RequestParam("name") String name) {
        String greetBodyOfCore = coreService.getGreet(name);
        return ResponseEntity.ok("greetBodyOfCore: ".concat(Objects.requireNonNull(greetBodyOfCore)));
    }

    @GetMapping("/addition")
    public ResponseEntity<String> addition(@RequestBody AdditionDto additionDto) {
        if (Objects.isNull(additionDto.getV1()) || Objects.isNull(additionDto.getV2())) throw new InvalidParamException();
        Long additionResult = coreService.getAdditionTwoValues(additionDto.getV1(), additionDto.getV2());
        return ResponseEntity.ok("Result of the core service: ".concat(String.valueOf(additionResult)));
    }
}
