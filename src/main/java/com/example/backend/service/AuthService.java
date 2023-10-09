package com.example.backend.service;

import com.example.backend.dto.AuthenticationRequest;
import com.example.backend.dto.RegistrationRequest;
import com.example.backend.entity.User;
import com.example.backend.exception.FailedToAccessException;
import com.example.backend.mapper.UserMapper;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public User login(AuthenticationRequest authenticationRequest) {
        User user = userRepository.findByUsername(authenticationRequest.getUsername());
        if (user == null || !user.getPassword().equals(authenticationRequest.getPassword()))
            throw FailedToAccessException.builder()
                    .message("Invalid username or password")
                    .httpStatus(HttpStatus.UNAUTHORIZED).build();
        return user;
    }

    @Transactional
    public User register(RegistrationRequest registrationRequest) {
        User user = userMapper.mapToUser(registrationRequest);
        if (userRepository.findByUsername(user.getUsername()) != null)
            throw FailedToAccessException.builder()
                    .message("Username already exists")
                    .httpStatus(HttpStatus.BAD_REQUEST).build();
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
