package com.example.backend.service;

import com.example.backend.data.exception.FailedToAccessException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationUtils {
    private final Validator validator;
//TODO remove
    public <T> void validate(T entity) {
        if (entity != null) {
            Set<ConstraintViolation<T>> validateResult = validator.validate(entity);
            if (!validateResult.isEmpty()) {
                String allValidateTroubles = validateResult.stream()
                        .map(ConstraintViolation::getMessage)
                        .reduce((m1, m2) -> m1 + ", " + m2)
                        .get();
                throw new FailedToAccessException(allValidateTroubles);
            }
        }
    }
}
