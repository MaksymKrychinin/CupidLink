package com.example.backend.data.exception;

public class UserProcessingException extends RuntimeException{
    public UserProcessingException(String message) {
        super(message);
    }
}
