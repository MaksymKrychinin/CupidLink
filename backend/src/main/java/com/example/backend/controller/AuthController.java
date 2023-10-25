package com.example.backend.controller;


import com.example.backend.data.dto.AuthenticationRequest;
import com.example.backend.data.dto.AuthenticationResponse;
import com.example.backend.data.dto.RegisterRequest;
import com.example.backend.service.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authService;


    @PostMapping("/register")
    @SecurityRequirements()
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    @SecurityRequirements()
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.auth(request));
    }
}
