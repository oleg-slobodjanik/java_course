package com.slobodianyk.homework3;

import java.util.regex.Pattern;

public class UserValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{10,15}$");

    public void validate(UserRegistrationDto dto) {
        if (dto.getEmail() == null || !EMAIL_PATTERN.matcher(dto.getEmail()).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (dto.getPhoneNumber() != null && !PHONE_PATTERN.matcher(dto.getPhoneNumber()).matches()) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        if (!dto.getPassword().equals(dto.getRepeatPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
    }

    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber == null || phoneNumber.matches("^\\+?\\d{10,15}$");
    }

    public boolean passwordsMatch(String password, String repeatPassword) {
        return password != null && password.equals(repeatPassword);
    }

    public boolean isValid(UserRegistrationDto userDto) {
        return isValidEmail(userDto.getEmail())
                && isValidPhoneNumber(userDto.getPhoneNumber())
                && passwordsMatch(userDto.getPassword(), userDto.getRepeatPassword());
    }
}
