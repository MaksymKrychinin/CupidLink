package com.example.backend.data.mapper;


import com.example.backend.data.dto.RegisterRequest;
import com.example.backend.data.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserMapperRegisterRequest implements Function<RegisterRequest, User> {
    private final PasswordEncoder passwordEncoder;

    @Override
    public User apply(RegisterRequest request) {
        return User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .openInfo(request.getOpenInfo())
                .secretInfo(request.getSecretInfo())
                .build();
    }
}
