package com.eduai.controller;

import com.eduai.dto.LoginRequest;
import com.eduai.dto.UserResponse;
import com.eduai.model.User;
import com.eduai.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ LOGIN (password NOT returned)
    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest request) {

        User user = authService.authenticate(
                request.getUsername(),
                request.getPassword()
        );

        if (user == null) {
            throw new RuntimeException("Invalid username or password");
        }

        return new UserResponse(
                user.getUsername(),
                user.getRole()
        );
    }

    // ✅ REGISTER (first-time users)
    @PostMapping("/register")
    public UserResponse register(@RequestBody User user) {

        User savedUser = authService.register(user);

        return new UserResponse(
                savedUser.getUsername(),
                savedUser.getRole()
        );
    }

    // ✅ FORGOT PASSWORD (MOCK IMPLEMENTATION)
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody Map<String, String> body) {

        String username = body.get("username");

        // Mock logic (email reset can be added later)
        System.out.println("Password reset requested for user: " + username);

        return "Password reset link sent (mock)";
    }
}
