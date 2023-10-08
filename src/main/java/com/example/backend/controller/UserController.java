package com.example.backend.controller;

import com.example.backend.entity.User;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @RequestBody User userUpdates,
            @PathVariable Long id) {
        User user = userService.update(userUpdates, id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(
            @RequestBody User currentUser,
            @PathVariable Long id) {
        User user = userService.findById(currentUser, id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{keywords}")
    public ResponseEntity<List<User>> findByKeyword(
            @RequestBody User currentUser,
            @PathVariable String keywords) {
        List<User> userList = userService.findByKeyword(currentUser, keywords);
        return ResponseEntity.ok(userList);
    }
}
