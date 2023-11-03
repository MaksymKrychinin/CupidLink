package com.example.backend.data.dto;


import com.example.backend.data.entity.OpenInfo;
import com.example.backend.data.entity.SecretInfo;
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
public class RegisterRequest {
    private Long id;
    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    @Min(value = 8, message = "Password must be at least 8 characters")
    private String password;
    private OpenInfo openInfo;
    private SecretInfo secretInfo;
}
