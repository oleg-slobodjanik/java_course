package com.slobodianyk.homework4.interfaces;

import com.slobodianyk.homework4.User;

import java.util.Optional;

public interface UserRepository {
    User create(User user);

    User update(User user);

    Optional<User> findById(Long id);
}
