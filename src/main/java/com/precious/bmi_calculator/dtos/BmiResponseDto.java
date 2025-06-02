package com.precious.bmi_calculator.dtos;

import com.precious.bmi_calculator.enums.BmiCategories;

public record BmiResponseDto(String name, double value, BmiCategories category) {
}
