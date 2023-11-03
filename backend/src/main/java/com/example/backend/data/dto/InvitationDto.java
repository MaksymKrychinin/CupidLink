package com.example.backend.data.dto;

import com.example.backend.data.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvitationDto {

    private Long id;
    @JsonIgnore
    private UserDto sender;
    private UserDto receiver;
    private String message;
    private LocalDateTime sentDateTime;
}