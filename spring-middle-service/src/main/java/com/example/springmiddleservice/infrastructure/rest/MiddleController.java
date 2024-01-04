package com.example.springmiddleservice.infrastructure.rest;

import com.example.springmiddleservice.config.kafka.KafkaProducer;
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
    @Setter(onMethod = @__(@Autowired))
    private KafkaProducer kafkaProducer;


    @GetMapping("/greet")
    public ResponseEntity<String> greet(@RequestParam("name") String name) {
        String greetBodyOfCore = coreService.getGreet(name);
        String result = "greetBodyOfCore: ".concat(Objects.requireNonNull(greetBodyOfCore));
        kafkaProducer.sendMessage(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/addition")
    public ResponseEntity<String> addition(@RequestBody AdditionDto additionDto) {
        if (Objects.isNull(additionDto.getV1()) || Objects.isNull(additionDto.getV2())) throw new InvalidParamException();
        Long additionResult = coreService.getAdditionTwoValues(additionDto.getV1(), additionDto.getV2());
        String result = "Result of the core service: ".concat(String.valueOf(additionResult));
        kafkaProducer.sendMessage("Result of the core service: ".concat(String.valueOf(additionResult)));
        return ResponseEntity.ok(result);
    }
}
