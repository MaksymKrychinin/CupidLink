package com.example.backend.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OpenInfoDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String location;
    private String description;
}
