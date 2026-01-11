package com.eduai.service;

import com.eduai.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    // In-memory user store (temporary)
    private final List<User> users = new ArrayList<>();

    // Preloaded users
    public AuthService() {
        users.add(new User("student1", "pass123", "Student"));
        users.add(new User("student2", "pass123", "Student"));
        users.add(new User("faculty1", "admin123", "Faculty"));
    }

    // Login
    public User authenticate(String username, String password) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username)
                        && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    // Register (Sign-Up)
    public User register(User newUser) {
        boolean exists = users.stream()
                .anyMatch(u -> u.getUsername().equals(newUser.getUsername()));

        if (exists) {
            throw new RuntimeException("Username already exists");
        }

        users.add(newUser);
        return newUser;
    }
}
