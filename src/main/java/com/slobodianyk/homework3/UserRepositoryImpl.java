package com.slobodianyk.homework3;

import com.slobodianyk.homework3.interfaces.UserRepository;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private Map<Long, User> users = new HashMap<>();
    private long currentId = 1;

    @Override
    public void save(User user) {
        user.setId(currentId++);
        users.put(user.getId(), user);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(users.get(userId));
    }
}