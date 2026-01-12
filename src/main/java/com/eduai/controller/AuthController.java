package com.eduai.controller;

import com.eduai.dto.LoginRequest;
import com.eduai.dto.UserResponse;
import com.eduai.model.User;
import com.eduai.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(
            @RequestBody LoginRequest request
    ) {
        User user = authService.login(
                request.getUsername(),
                request.getPassword()
        );

        return ResponseEntity.ok(
                new UserResponse(
                        user.getUsername(),
                        user.getRole()
                )
        );
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        if (authService.existsByUsername(user.getUsername())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("User already exists");
        }

        User savedUser = authService.register(user);

        return ResponseEntity.ok(
                new UserResponse(
                        savedUser.getUsername(),
                        savedUser.getRole()
                )
        );
    }
}
