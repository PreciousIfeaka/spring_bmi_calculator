package com.precious.bmi_calculator.controllers;

import com.precious.bmi_calculator.exceptions.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorDetails> invalidRequestExceptionHandler(HttpMessageNotReadableException e) {
        ErrorDetails errorDetails = new ErrorDetails(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
