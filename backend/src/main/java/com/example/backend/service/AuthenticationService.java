package com.example.backend.service;


import com.example.backend.data.dto.AuthenticationRequest;
import com.example.backend.data.dto.AuthenticationResponse;
import com.example.backend.data.dto.RegisterRequest;
import com.example.backend.data.dto.UserDto;
import com.example.backend.data.entity.User;
import com.example.backend.data.exception.FailedToAccessException;
import com.example.backend.data.mapper.UserMapper;
import com.example.backend.data.mapper.UserMapperRegisterRequest;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final ValidationUtils validationUtils;

    public AuthenticationResponse register(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
              .token(jwtToken)
              .build();
    }

    public AuthenticationResponse auth(AuthenticationRequest request) {
        User user = userRepository.findUserByUsername(request.getUsername())
              .orElseThrow(() -> new FailedToAccessException("User not found by username"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new FailedToAccessException("Password does not match");
        }
        new UsernamePasswordAuthenticationToken(
              request.getUsername(),
              request.getPassword()
        );
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
              .token(jwtToken)
              .build();
    }
}
