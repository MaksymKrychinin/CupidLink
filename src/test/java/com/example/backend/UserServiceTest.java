package com.example.backend;

import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
public class UserServiceTest {
    final UserService userService;

    @Test
    void contextLoads() {
    }

    //test for user service to update if user id not equals long id, throw exception
    @Test
    void testUpdateUserByIdNotEqualsId() {
        User user = User.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .email("custom@mail.com")
                .build();
        assertThrows(IllegalArgumentException.class,
                () -> userService.update(user, 2L));
    }

    //test for user service to update if user not found, throw exception
    @Test
    void testUpdateUserByIdNotFound() {
        User user = User.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .email("custom@mail.com")
                .build();
        ;
        assertThrows(IllegalArgumentException.class,
                () -> userService.update(user, 1L));
    }
}
