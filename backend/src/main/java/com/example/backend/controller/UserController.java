package com.example.backend.controller;

import com.example.backend.data.dto.UserDto;
import com.example.backend.data.entity.User;
import com.example.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "Create user",
            description = "Create user with given userDto"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/")
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id, @RequestBody User user) {
        return userService.getUserById(id, user.getId());
    }

    @GetMapping("/{id}/page={pageNum}")
    public Page<UserDto> getFriendsByUserId(
            @PathVariable("id") Long id,
            @PathVariable("pageNum") Integer pageNum) {
        return userService.getFriendsByUserId(id, pageNum);
    }

    @GetMapping("/{keywordValue}/page={pageNum}")
    public Page<UserDto> getUsersByKeyword(
            @PathVariable String keywordValue,
            @PathVariable Integer pageNum) {
        return userService.getUsersByKeyword(keywordValue, pageNum);
    }
}
