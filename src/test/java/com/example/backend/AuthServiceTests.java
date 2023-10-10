package com.example.backend;

import com.example.backend.service.AuthService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthServiceTests {
    private static AuthService authService;
    @BeforeAll
    static void contextLoads() {
    }

}
