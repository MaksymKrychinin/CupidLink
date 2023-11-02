package com.example.backend.data.exception;

public class FailedToAccessException extends RuntimeException {
    public FailedToAccessException() {
    }

    public FailedToAccessException(String message) {
        super(message);
    }

    public FailedToAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToAccessException(Throwable cause) {
        super(cause);
    }

    public FailedToAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
