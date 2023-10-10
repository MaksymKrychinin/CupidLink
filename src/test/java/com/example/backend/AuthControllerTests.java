package com.example.backend;

import com.example.backend.controller.AuthController;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.AuthService;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class AuthControllerTests {
    private MockMvc mockMvc;
    @Mock
    private AuthService authService;
    private AutoCloseable autoCloseable;
    @InjectMocks
    private AuthController authController;


    @BeforeAll
    void init() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new AuthController(authService)).build();
    }


    @AfterAll
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
