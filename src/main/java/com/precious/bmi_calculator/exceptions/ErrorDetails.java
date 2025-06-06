package com.precious.bmi_calculator.exceptions;


public record ErrorDetails(boolean success, String message, int statusCode) {
}
