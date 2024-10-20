package com.slobodianyk.homework4;

import com.slobodianyk.homework4.interfaces.RoleRepository;
import com.slobodianyk.homework4.interfaces.UserRepository;
import com.slobodianyk.homework4.repositories.RoleRepositoryImpl;
import com.slobodianyk.homework4.repositories.UserRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Main {
    // MySQL connection details
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/java_db";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "123";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);

            RoleRepository roleRepository = new RoleRepositoryImpl(connection);
            UserRepository userRepository = new UserRepositoryImpl(connection);

            Role adminRole = roleRepository.create(new Role(null, "Admin"));
            Role userRole = roleRepository.create(new Role(null, "User"));

            User user = new User(null, "Drue Stone", "drue@example.com");
            userRepository.create(user);

            user.setName("Drue Stone Updated");
            userRepository.update(user);

            Optional<User> foundUser = userRepository.findById(user.getId());
            foundUser.ifPresent(u -> System.out.println("Found user: " + u.getName()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
