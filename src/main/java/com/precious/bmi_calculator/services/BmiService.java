package com.precious.bmi_calculator.services;

import com.precious.bmi_calculator.dtos.BmiRequestDto;
import com.precious.bmi_calculator.dtos.BmiResponseDto;
import com.precious.bmi_calculator.enums.BmiCategories;
import com.precious.bmi_calculator.enums.BmiUnit;
import com.precious.bmi_calculator.models.User;
import com.precious.bmi_calculator.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class BmiService {
    UserRepository userRepository;

    public BmiService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public BmiResponseDto calculateBmi(BmiRequestDto bmiRequestDto) {
        BmiUnit unit = bmiRequestDto.getUnit();
        float weight = bmiRequestDto.getWeight();
        float height = bmiRequestDto.getHeight();
        String name = bmiRequestDto.getName();

        float bmi;
        if (BmiUnit.METRIC.equals(unit)) {
            bmi = weight / (height * height);
        } else bmi = (weight * 703) / (height * height);

        BmiCategories category = getBmiCategory(bmi);

        User user = new User();
        user.setBmi(bmi);
        user.setBmiUnit(unit);
        user.setCategory(category);
        user.setHeight(height);
        user.setName(name);
        user.setHeight(height);
        user.setWeight(weight);

        User savedUser = this.userRepository.save(user);

        return new BmiResponseDto(savedUser.getId(), name, savedUser.getBmi(), savedUser.getCategory());
    }

    public BmiCategories getBmiCategory(float bmi) {
        if (bmi < 18.5) return BmiCategories.UNDERWEIGHT;
        else if (bmi <= 24.9) return BmiCategories.NORMAL;
        else if (bmi <= 29.9) return BmiCategories.OVERWEIGHT;
        else return BmiCategories.OBESITY;
    }
}
