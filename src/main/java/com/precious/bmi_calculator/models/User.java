package com.precious.bmi_calculator.models;

import com.precious.bmi_calculator.enums.BmiCategories;
import com.precious.bmi_calculator.enums.BmiUnit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String name;

    @Positive
    private Float height;

    @Positive
    private Float weight;

    @Enumerated(EnumType.STRING)
    private BmiUnit bmiUnit;

    @Positive
    private Float bmi;

    private BmiCategories category;
}
