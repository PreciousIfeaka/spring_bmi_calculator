package com.precious.bmi_calculator.repositories;

import com.precious.bmi_calculator.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
