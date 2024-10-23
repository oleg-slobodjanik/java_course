package com.slobodianyk.mokito.service.impl;

import com.slobodianyk.homework3.UserRegistrationDto;
import com.slobodianyk.homework3.UserValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserValidatorTest {

    private final UserValidator userValidator = new UserValidator();

    @Test
    void validateUserRegistration_shouldThrowException_whenEmailIsInvalid() {
        UserRegistrationDto dto = new UserRegistrationDto();
        dto.setEmail("invalidEmail");
        dto.setPhoneNumber("+38012652937");
        dto.setPassword("password123");
        dto.setRepeatPassword("password123");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userValidator.validateUserRegistration(dto);
        });

        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void validateUserRegistration_shouldThrowException_whenPasswordsDoNotMatch() {
        UserRegistrationDto dto = new UserRegistrationDto();
        dto.setEmail("test@gmail.com");
        dto.setPhoneNumber("+38012652937");
        dto.setPassword("password123");
        dto.setRepeatPassword("password321");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userValidator.validateUserRegistration(dto);
        });

        assertEquals("Passwords do not match", exception.getMessage());
    }

    @Test
    void validateUserRegistration_shouldThrowException_whenPhoneNumberIsInvalid() {
        UserRegistrationDto dto = new UserRegistrationDto();
        dto.setEmail("test@gmail.com");
        dto.setPhoneNumber("12345");
        dto.setPassword("password123");
        dto.setRepeatPassword("password123");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userValidator.validateUserRegistration(dto);
        });

        assertEquals("Invalid phone number format", exception.getMessage());
    }

    @Test
    void validateUserRegistration_shouldNotThrowException_whenAllFieldsAreValid() {
        UserRegistrationDto dto = new UserRegistrationDto();
        dto.setEmail("test@gmail.com");
        dto.setPhoneNumber("+38012652937");
        dto.setPassword("password123");
        dto.setRepeatPassword("password123");

        assertDoesNotThrow(() -> userValidator.validateUserRegistration(dto));
    }
}
