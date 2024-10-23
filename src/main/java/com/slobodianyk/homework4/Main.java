package com.slobodianyk.homework4;

import com.slobodianyk.homework4.models.Role;
import com.slobodianyk.homework4.models.User;
import com.slobodianyk.homework4.repositories.RoleRepository;
import com.slobodianyk.homework4.repositories.UserRepository;
import com.slobodianyk.homework4.util.HibernateUtil;

import java.util.Optional;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Main {
    @SuppressWarnings("checkstyle:RegexpSingleline")
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        RoleRepository roleRepository = new RoleRepository();

        Role adminRole = new Role();
        adminRole.setName("Admin");
        roleRepository.create(adminRole);

        Role userRole = new Role();
        userRole.setName("User");
        roleRepository.create(userRole);

        User user = new User();
        user.setName("Tom Cruse");
        user.setEmail("tom.cruse@example.com");

        user.getRoles().add(adminRole);
        user.getRoles().add(userRole);

        userRepository.create(user);

        Optional<User> retrievedUser = userRepository.findById(user.getId());
        retrievedUser.ifPresent(System.out::println);

        HibernateUtil.shutdown();
    }
}
