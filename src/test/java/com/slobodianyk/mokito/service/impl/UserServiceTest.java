package com.slobodianyk.mokito.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.slobodianyk.homework3.User;
import com.slobodianyk.homework3.UserRegistrationDto;
import com.slobodianyk.homework3.UserServiceImpl;
import com.slobodianyk.homework3.interfaces.UserRepository;
import com.slobodianyk.homework3.interfaces.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void registerUser() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setEmail("oleg@test.com");
        userRegistrationDto.setPhoneNumber("+38012652937");
        userRegistrationDto.setPassword("password123");
        userRegistrationDto.setRepeatPassword("password123");

        User user = new User(
                1L,
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPhoneNumber(),
                userRegistrationDto.getPassword()
        );

        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .thenReturn(user);

        UserResponseDto result = userService.registerUser(userRegistrationDto);

        assertEquals(1L, result.id());
        assertEquals(userRegistrationDto.getEmail(), result.email());
        assertEquals(userRegistrationDto.getPhoneNumber(), result.phoneNumber());
    }

    @Test
    void getUserById() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.of(new User(
                        1L,
                        "test@test.com",
                        null,
                        "password123"
                )));

        Mockito.when(userRepository.findById(2L))
                .thenReturn(Optional.empty());

        UserResponseDto result = userService.getUserById(1L);
        assertEquals(1L, result.id());
        assertEquals("test@test.com", result.email());
        assertNull(result.phoneNumber());

        assertThrows(RuntimeException.class, () -> userService.getUserById(2L),
                "No value present"
        );
    }
}
