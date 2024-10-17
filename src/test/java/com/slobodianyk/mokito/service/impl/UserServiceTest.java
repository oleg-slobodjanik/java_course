package com.slobodianyk.mokito.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

import com.slobodianyk.homework3.User;
import com.slobodianyk.homework3.UserRegistrationDto;
import com.slobodianyk.homework3.UserServiceImpl;
import com.slobodianyk.homework3.UserValidator;
import com.slobodianyk.homework3.interfaces.UserRepository;
import com.slobodianyk.homework3.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class UserServiceTest {
    private UserRepository userRepository;
    private UserValidator userValidator;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userValidator = mock(UserValidator.class);
        userService = new UserServiceImpl(userRepository, userValidator);
    }

    @Test
    void testRegisterUser() {
        UserRegistrationDto userDto = new UserRegistrationDto(
                "test@test.com",
                null,
                "password",
                "password");

        doAnswer(invocation -> {
            User u = invocation.getArgument(0);
            u.setId(1L);
            return null;
        }).when(userRepository).save(any(User.class));

        userService.registerUser(userDto);

        verify(userRepository).save(any(User.class));
    }

    @Test
    void testGetUserById() {
        User user = new User(
                1L,
                "test@test.com",
                null,
                "password"
        );
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserService.UserResponseDto response = userService.getUserById(1L);
        assertEquals(1L, response.id());
        assertEquals("test@test.com", response.email());
    }
}