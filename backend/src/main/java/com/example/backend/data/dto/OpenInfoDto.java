package com.example.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenInfoDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String location;
    private String description;
}
