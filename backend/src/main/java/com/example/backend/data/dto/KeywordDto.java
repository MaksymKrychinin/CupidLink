package com.example.backend.data.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeywordDto {
    private Long id;
    @NotNull(message = "Value cannot be null")
    @NotEmpty(message = "Value cannot be empty")
    private String value;
}
