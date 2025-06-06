package com.precious.bmi_calculator.controllers;

import com.precious.bmi_calculator.dtos.BmiRequestDto;
import com.precious.bmi_calculator.dtos.BmiResponseDto;
import com.precious.bmi_calculator.services.BmiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bmi")
public class BmiController {
    private final BmiService bmiService;

    public BmiController(BmiService bmiService) {
        this.bmiService = bmiService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<BmiResponseDto> calculateBmi(
            @RequestBody BmiRequestDto bmiRequestDto
    ) {
        BmiResponseDto bmiResponse = bmiService.calculateBmi(bmiRequestDto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bmiResponse);
    }
}
