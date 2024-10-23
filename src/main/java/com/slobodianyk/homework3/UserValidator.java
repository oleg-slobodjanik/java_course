package com.slobodianyk.homework3;

import java.util.regex.Pattern;

public class UserValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{10,15}$");

    public void validateUserRegistration(UserRegistrationDto userRegistrationDto) {
        validateEmail(userRegistrationDto.getEmail());
        validatePassword(userRegistrationDto.getPassword(), userRegistrationDto.getRepeatPassword());
        validatePhoneNumber(userRegistrationDto.getPhoneNumber());
    }

    public void validateEmail(String email) {
        if (email == null || !email.contains("@") || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new RuntimeException("Invalid email format");
        }
    }

    public void validatePassword(String password, String repeatPassword) {
        if (password == null || !password.equals(repeatPassword)) {
            throw new RuntimeException("Passwords do not match");
        }
    }

    public void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.matches("^\\+?[0-9]{10,15}$")) {
            throw new RuntimeException("Invalid phone number format");
        }
    }
}
