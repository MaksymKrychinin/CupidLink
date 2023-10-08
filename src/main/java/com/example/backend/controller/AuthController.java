package com.example.backend.controller;

import com.example.backend.dto.AuthenticationRequest;
import com.example.backend.dto.RegistrationRequest;
import com.example.backend.entity.User;
import com.example.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<User> login(
            @Validated @RequestBody AuthenticationRequest authenticationRequest
    ) {
        User user = service.login(authenticationRequest);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @Validated @RequestBody RegistrationRequest registrationRequest
    ) {
        User user = service.register(registrationRequest);
        return ResponseEntity.ok(user);
    }
}
