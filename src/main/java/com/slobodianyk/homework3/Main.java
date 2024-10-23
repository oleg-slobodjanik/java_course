package com.slobodianyk.homework3;

import com.slobodianyk.homework3.interfaces.UserRepository;
import com.slobodianyk.homework3.interfaces.UserService;
import com.slobodianyk.homework3.interfaces.UserResponseDto;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryJdbcImpl();
        UserValidator userValidator = new UserValidator();
        UserService userService = new UserServiceImpl(userRepository, userValidator);

        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.setEmail("bob@gmail.com");
        userDto.setPhoneNumber("+38085452937");
        userDto.setPassword("password321");
        userDto.setRepeatPassword("password321");

        UserResponseDto registeredUser = userService.registerUser(userDto);
        System.out.println("User registered: " + registeredUser);

        UserResponseDto retrievedUser = userService.getUserById(registeredUser.id());
        System.out.println("Retrieved User: " + retrievedUser);
    }
}
