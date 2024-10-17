package com.slobodianyk.homework3.interfaces;

import com.slobodianyk.homework3.UserRegistrationDto;

public interface UserService {
    UserResponseDto registerUser(UserRegistrationDto userRegistrationDto);
    UserResponseDto getUserById(Long userId);

    // UserResponseDto (using Java record for simplicity)
    record UserResponseDto(Long id, String email, String phoneNumber) { }
}

