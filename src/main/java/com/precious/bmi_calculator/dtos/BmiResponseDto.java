package com.precious.bmi_calculator.dtos;

import com.precious.bmi_calculator.enums.BmiCategories;

import java.util.UUID;

public record BmiResponseDto(
        UUID id,
        String name,
        float value,
        BmiCategories category
) {}
