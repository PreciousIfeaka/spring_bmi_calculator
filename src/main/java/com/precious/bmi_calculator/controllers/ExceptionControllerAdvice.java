package com.precious.bmi_calculator.controllers;

import com.precious.bmi_calculator.exceptions.ErrorDetails;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDetails> handleConstraintViolation(ConstraintViolationException ex) {
        List<String> messages = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        // You can join them into one message, or return a list
        String message = String.join("; ", messages);
        ErrorDetails errorDetails = new ErrorDetails(false, message, 422);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
