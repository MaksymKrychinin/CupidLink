package com.example.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@Getter
@Setter
public class AuthenticationRequest {
    @NotNull
    @Length(min = 4, max = 32, message = "Username must be between 4 and 32 characters")
    private String username;
    @NotNull
    @Length(min = 8, max = 32, message = "Password must be between 8 and 32 characters")
    private String password;
}
