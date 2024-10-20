package com.slobodianyk.mokito.service.impl;

import com.slobodianyk.homework3.UserRegistrationDto;
import com.slobodianyk.homework3.UserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UserValidatorTest {

    private UserValidator userValidator;

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator();
    }

    @Test
    void testIsValidEmail_Valid() {
        assertTrue(userValidator.isValidEmail("test@example.com"));
    }

    @Test
    void testIsValidEmail_Invalid() {
        assertFalse(userValidator.isValidEmail("test@example"));
        assertFalse(userValidator.isValidEmail("invalid-email"));
        assertFalse(userValidator.isValidEmail(null));
    }

    @Test
    void testIsValidPhoneNumber_Valid() {
        assertTrue(userValidator.isValidPhoneNumber("+12345678901"));
        assertTrue(userValidator.isValidPhoneNumber("1234567890"));
        assertTrue(userValidator.isValidPhoneNumber(null));
    }

    @Test
    void testIsValidPhoneNumber_Invalid() {
        assertFalse(userValidator.isValidPhoneNumber("12345"));
        assertFalse(userValidator.isValidPhoneNumber("+12abc567890"));
    }

    @Test
    void testPasswordsMatch_Valid() {
        assertTrue(userValidator.passwordsMatch("password123", "password123"));
    }

    @Test
    void testPasswordsMatch_Invalid() {
        assertFalse(userValidator.passwordsMatch("password123", "password321"));
        assertFalse(userValidator.passwordsMatch(null, "password123"));
    }

    @Test
    void testIsValid_ValidUserDto() {
        UserRegistrationDto userDto = new UserRegistrationDto(
                "test@example.com",
                "+12345678901",
                "password123",
                "password123"
        );

        assertTrue(userValidator.isValid(userDto));
    }

    @Test
    void testIsValid_InvalidEmail() {
        UserRegistrationDto userDto = new UserRegistrationDto(
                "invalid-email",
                "+12345678901",
                "password123",
                "password123"
        );

        assertFalse(userValidator.isValid(userDto));
    }

    @Test
    void testIsValid_InvalidPhoneNumber() {
        UserRegistrationDto userDto = new UserRegistrationDto(
                "test@example.com",
                "12345",
                "password123",
                "password123"
        );

        assertFalse(userValidator.isValid(userDto));
    }

    @Test
    void testIsValid_PasswordsDoNotMatch() {
        UserRegistrationDto userDto = new UserRegistrationDto(
                "test@example.com",
                "+12345678901",
                "password123",
                "password321"
        );

        assertFalse(userValidator.isValid(userDto));
    }
}
