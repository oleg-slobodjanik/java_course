package com.slobodianyk.homework4.interfaces;

import com.slobodianyk.homework4.Role;

import java.util.Optional;

public interface RoleRepository {
    Role create(Role role);

    Optional<Role> findById(Long id);
}
