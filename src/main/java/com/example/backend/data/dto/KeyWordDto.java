package com.example.backend.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KeyWordDto {
    private Long id;
    private String value;
}
