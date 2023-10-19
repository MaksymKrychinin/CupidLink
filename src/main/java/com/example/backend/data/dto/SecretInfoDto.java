package com.example.backend.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecretInfoDto {
    private Long id;
    private String email;
    private String phone;
}
