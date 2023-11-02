package com.example.backend.data.dto;


import com.example.backend.data.entity.OpenInfo;
import com.example.backend.data.entity.SecretInfo;
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
    private String username;
    private String password;
    private OpenInfo openInfo;
    private SecretInfo secretInfo;
}
