package com.slobodianyk.homework3;

import com.slobodianyk.homework3.interfaces.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class UserRepositoryJdbcImpl implements UserRepository {

    // MySQL connection details
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/java_db";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "123";

    public UserRepositoryJdbcImpl() {
        // Підключення до MySQL і створення таблиці користувачів, якщо вона ще не існує
        try (Connection connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
             Statement stmt = connection.createStatement()) {
            String createTableSql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id BIGINT AUTO_INCREMENT PRIMARY KEY, "
                    + "email VARCHAR(255) NOT NULL, "
                    + "phone_number VARCHAR(20), "
                    + "password VARCHAR(255) NOT NULL)";
            stmt.execute(createTableSql);
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing the database", e);
        }
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (email, phone_number, password) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPhoneNumber());
            pstmt.setString(3, user.getPassword());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getLong(1)); // Отримуємо ID користувача
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error saving user", e);
        }
    }

    @Override
    public Optional<User> findById(Long userId) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setLong(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String email = rs.getString("email");
                    String phoneNumber = rs.getString("phone_number");
                    String password = rs.getString("password");
                    User user = new User(userId, email, phoneNumber, password);
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user", e);
        }

        return Optional.empty();
    }
}
