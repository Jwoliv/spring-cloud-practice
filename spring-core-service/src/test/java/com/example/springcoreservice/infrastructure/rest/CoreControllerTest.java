package com.example.springcoreservice.infrastructure.rest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static com.example.springcoreservice.utils.ParamsRequest.*;
import static com.example.springcoreservice.utils.StringProcessor.containsSubstring;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CoreControllerTest {

    @InjectMocks
    private CoreController coreController;

    @Test
    public void getGreet_withName_shouldSuccess() {
        ResponseEntity<String> responseEntity = coreController.getGreet(VALID_NAME);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertThat(responseEntity.getBody(), containsString("John"));
    }

    @Test
    public void getGreet_withoutName_shouldSuccess() {
        ResponseEntity<String> responseEntity = coreController.getGreet(INVALID_NAME);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertThat(responseEntity.getBody(), containsString("Someone"));
    }

    @Test
    public void getAdditionTwoValues_withSecondParam_shouldSuccess() {
        ResponseEntity<String> responseEntity = coreController.getAdditionTwoValues(VALID_VALUE_1, VALID_VALUE_2);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("15", responseEntity.getBody(), "Correct response body");
    }

    @Test
    public void getAdditionTwoValues_withoutFirstParam_shouldError() {
        ResponseEntity<String> responseEntity = coreController.getAdditionTwoValues(VALID_VALUE_1, INVALID_VALUE_2);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(containsSubstring(Objects.requireNonNull(responseEntity.getBody()), STRING_FOR_CHECK_GET_GREET));
    }

    @Test
    public void getAdditionTwoValues_withoutOneParam_shouldError() {
        ResponseEntity<String> responseEntity = coreController.getAdditionTwoValues(INVALID_VALUE_1, VALID_VALUE_2);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(containsSubstring(Objects.requireNonNull(responseEntity.getBody()), STRING_FOR_CHECK_GET_GREET));
    }

    @Test
    public void getAdditionTwoValues_withoutBothParams_shouldError() {
        ResponseEntity<String> responseEntity = coreController.getAdditionTwoValues(INVALID_VALUE_1, INVALID_VALUE_2);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(containsSubstring(Objects.requireNonNull(responseEntity.getBody()), STRING_FOR_CHECK_GET_GREET));
    }
}
