package com.precious.bmi_calculator.exceptions;

public class ErrorDetails {
    private final String message;

    public ErrorDetails(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
