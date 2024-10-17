package com.slobodianyk.homework3;

import com.slobodianyk.homework3.interfaces.UserRepository;
import com.slobodianyk.homework3.interfaces.UserService;
import com.slobodianyk.homework3.interfaces.UserService.UserResponseDto;

public class Main {
    public static void main(String[] args) {
//        UserRepository userRepository = new UserRepositoryImpl();
//        UserValidator userValidator = new UserValidator();
//        UserService userService = new UserServiceImpl(userRepository, userValidator);
//
//        // Створюємо DTO для реєстрації
//        UserRegistrationDto userDto = new UserRegistrationDto(
//                "example@test.com",
//                "+1234567890",
//                "password123",
//                "password123");
//
//        // Реєструємо користувача, використовуючи метод registerUser
//        UserResponseDto registeredUser = userService.registerUser(userDto);
//
//        // Реєструємо користувача
//        System.out.println("User registered: " + registeredUser);
//
//        // Отримуємо користувача за ID
//        UserResponseDto retrievedUser = userService.getUserById(registeredUser.id());
//        System.out.println("Retrieved User: " + retrievedUser);

        // ===========================================================

        // Ініціалізуємо репозиторій і сервіси для роботи з MySQL
        UserRepository userRepository = new UserRepositoryJdbcImpl();  // MySQL JDBC реалізація
        UserValidator userValidator = new UserValidator();
        UserService userService = new UserServiceImpl(userRepository, userValidator);

        // Створюємо DTO для реєстрації нового користувача
        UserRegistrationDto userDto = new UserRegistrationDto(
                "test@test.com",
                "+5263242878",
                "password123",
                "password123"
        );

        // Реєструємо користувача
        UserResponseDto registeredUser = userService.registerUser(userDto);
        System.out.println("User registered: " + registeredUser);

        // Отримуємо користувача за ID
        UserResponseDto retrievedUser = userService.getUserById(registeredUser.id());
        System.out.println("Retrieved User: " + retrievedUser);
    }
}