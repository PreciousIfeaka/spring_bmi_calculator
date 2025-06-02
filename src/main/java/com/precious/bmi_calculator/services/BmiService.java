package com.precious.bmi_calculator.services;

import com.precious.bmi_calculator.dtos.BmiRequestDto;
import com.precious.bmi_calculator.dtos.BmiResponseDto;
import com.precious.bmi_calculator.enums.BmiCategories;
import com.precious.bmi_calculator.enums.BmiUnit;
import org.springframework.stereotype.Service;

@Service
public class BmiService {
    public BmiResponseDto calculateBmi(BmiRequestDto bmiRequestDto) {
        BmiUnit unit = bmiRequestDto.getUnit();
        double weight = bmiRequestDto.getWeight();
        double height = bmiRequestDto.getHeight();
        String name = bmiRequestDto.getName();

        double bmi;
        if (BmiUnit.METRIC.equals(unit)) {
            bmi = weight / Math.pow(height, 2);
        } else bmi = (weight * 703) / Math.pow(height, 2);

        BmiCategories category = getBmiCategory(bmi);

        return new BmiResponseDto(name, bmi, category);
    }

    public BmiCategories getBmiCategory(double bmi) {
        if (bmi < 18.5) return BmiCategories.UNDERWEIGHT;
        else if (bmi <= 24.9) return BmiCategories.NORMAL;
        else if (bmi <= 29.9) return BmiCategories.OVERWEIGHT;
        else return BmiCategories.OBESITY;
    }
}
