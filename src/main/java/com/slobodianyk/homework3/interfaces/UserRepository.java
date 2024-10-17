package com.slobodianyk.homework3.interfaces;

import com.slobodianyk.homework3.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> findById(Long userId);
}
