package com.example.backend.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequest {
    @NotEmpty(message = "Username is required")
    @NotNull(message = "Username is required")
    private String username;
    @NotEmpty(message = "Password is required")
    @NotNull(message = "Password is required")
    @Min(value = 8, message = "Password must be at least 8 characters")
    private String password;
}
