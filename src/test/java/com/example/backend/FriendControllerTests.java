package com.example.backend;

import com.example.backend.controller.AuthController;
import com.example.backend.controller.FriendController;
import com.example.backend.service.AuthService;
import com.example.backend.service.FriendService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class FriendControllerTests {
    private MockMvc mockMvc;
    @Mock
    private FriendService friendService;
    private AutoCloseable autoCloseable;
    @InjectMocks
    private FriendService authController;


    @BeforeAll
    void init() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new FriendController(friendService)).build();
    }


    @AfterAll
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}
