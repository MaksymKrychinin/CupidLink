package com.example.backend.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class NotFoundException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;
}