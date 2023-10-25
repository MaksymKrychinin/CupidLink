package com.example.backend.data.dto;


import com.example.backend.data.entity.OpenInfo;
import com.example.backend.data.entity.SecretInfo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String username;
    private String password;
    private OpenInfo openInfo;
    private SecretInfo secretInfo;
}
