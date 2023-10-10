package com.example.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class RegistrationRequest {
    @NotNull
    @Length(min = 4, max = 32, message = "Username must be between 4 and 32 characters")
    private String username;
    @NotNull
    @Length(min = 8, max = 32, message = "Password must be between 8 and 32 characters")
    private String password;
    @NotNull
    @Email(message = "Email should be valid")
    private String email;
    @NotNull
    @NotEmpty(message = "First name must not be empty")
    private String firstName;
    @NotNull
    @NotEmpty(message = "Last name must not be empty")
    private String lastName;
}
