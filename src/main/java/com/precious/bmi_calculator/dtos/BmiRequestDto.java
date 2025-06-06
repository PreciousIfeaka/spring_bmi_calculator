package com.precious.bmi_calculator.dtos;

import com.precious.bmi_calculator.enums.BmiUnit;
import lombok.Data;

@Data
public class BmiRequestDto {
    private String name;
    private final float height;
    private final float weight;
    private final BmiUnit unit;
}
