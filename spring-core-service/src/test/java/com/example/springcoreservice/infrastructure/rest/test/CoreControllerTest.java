package com.example.springcoreservice.infrastructure.rest.test;

import com.example.springcoreservice.infrastructure.rest.CoreController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoreControllerTest {

    @InjectMocks
    private CoreController coreController;

    @Test
    public void getGreet_withName_shouldSuccess() {
        String name = "John";

        ResponseEntity<String> responseEntity = coreController.getGreet(name);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Status code should be 200 OK");
        assertEquals("Hello from core to John", responseEntity.getBody(), "Incorrect response body");
    }

    @Test
    public void getGreet_withoutName_shouldSuccess() {
        ResponseEntity<String> responseEntity = coreController.getGreet(null);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Status code should be 200 OK");
        assertEquals("Hello from core to Someone", responseEntity.getBody(), "Incorrect response body");
    }

    @Test
    public void getAdditionTwoValues_withTwoParam_shouldSuccess() {
        Long value1 = 5L;
        Long value2 = 10L;

        ResponseEntity<String> responseEntity = coreController.getAdditionTwoValues(value1, value2);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "Status code should be 200 OK");
        assertEquals("15", responseEntity.getBody(), "Incorrect response body");
    }

    @Test
    public void getAdditionTwoValues_withoutOneParam_shouldError() {
        Long value1 = 10L;
        Long value2 = null;

        ResponseEntity<String> responseEntity = coreController.getAdditionTwoValues(value1, value2);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Params is invalid: value1 = 10, value2 = null", responseEntity.getBody());
    }
}
