package com.example.backend.controller;

import com.example.backend.data.dto.UserDto;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private UserDetails userDetails;
    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        String a = userDetails.getUsername();
        return userService.getUserById(id, Long.getLong(a));
    }

    @GetMapping("/{id}/page={pageNum}")
    public Page<UserDto> getFriendsByUserId(@PathVariable("id") Long id, @PathVariable("pageNum")int pageNum) {
        return userService.getFriendsByUserId(id, pageNum);
    }

    @GetMapping("/{keywordValue}/page={pageNum}")
    public Page<UserDto> getUsersByKeyword(@PathVariable String keywordValue,@PathVariable int pageNum) {
        return userService.getUsersByKeyword(keywordValue, pageNum);
    }
}
