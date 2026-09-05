package com.adminPanel.app.exception;

import com.adminPanel.app.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(ProductException productException)
    {
        ErrorResponse response = new ErrorResponse();

        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(productException.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
    }
}
