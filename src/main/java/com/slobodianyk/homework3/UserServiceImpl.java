package com.slobodianyk.homework3;

import com.slobodianyk.homework3.interfaces.UserRepository;
import com.slobodianyk.homework3.interfaces.UserResponseDto;
import com.slobodianyk.homework3.interfaces.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public UserResponseDto registerUser(UserRegistrationDto userRegistrationDto) {
        // 1. Валідація
        userValidator.validate(userRegistrationDto);

        // 2. Створюємо користувача
        User user = new User(null, userRegistrationDto.getEmail(), userRegistrationDto.getPhoneNumber(), userRegistrationDto.getPassword());

        // 3. Зберігаємо в репозиторій
        userRepository.save(user);

        // 4. Повертаємо результат
        return new UserResponseDto(user.getId(), user.getEmail(), user.getPhoneNumber());
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UserResponseDto(user.getId(), user.getEmail(), user.getPhoneNumber());
    }
}
