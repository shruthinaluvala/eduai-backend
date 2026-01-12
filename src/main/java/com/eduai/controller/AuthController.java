package com.eduai.controller;

import com.eduai.dto.LoginRequest;
import com.eduai.dto.UserResponse;
import com.eduai.model.User;
import com.eduai.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public UserResponse register(@RequestBody User user) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User saved = userRepository.save(user);
        return new UserResponse(saved.getUsername(), saved.getRole());
    }

    // ✅ LOGIN (FIXED)
    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new UserResponse(user.getUsername(), user.getRole());
    }
}
