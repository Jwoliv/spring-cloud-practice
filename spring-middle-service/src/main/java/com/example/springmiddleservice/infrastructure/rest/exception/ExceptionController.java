package com.example.springmiddleservice.infrastructure.rest.exception;

import com.example.springmiddleservice.exception.InvalidParamException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<String> handleInvalidParamException() {
        return ResponseEntity.status(425).body("Invalid params of the request");
    }
}
