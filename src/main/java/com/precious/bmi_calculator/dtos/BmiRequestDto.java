package com.precious.bmi_calculator.dtos;

import com.precious.bmi_calculator.enums.BmiUnit;

public class BmiRequestDto {
    private String name;
    private final double height;
    private final double weight;
    private final BmiUnit unit;

    public BmiRequestDto(
            BmiUnit unit,
            double height,
            double weight
    ) {
        this.unit = unit;
        this.height = height;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public BmiUnit getUnit() {
        return unit;
    }
}
