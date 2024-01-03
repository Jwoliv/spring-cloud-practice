package com.example.springmiddleservice.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidParamException extends RuntimeException {
    public InvalidParamException() {
        super();
    }

    public InvalidParamException(String message) {
        super(message);
    }
}
