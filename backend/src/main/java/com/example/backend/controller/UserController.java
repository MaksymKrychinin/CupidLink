package com.example.backend.controller;

import com.example.backend.data.dto.UserDto;
import com.example.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "Get user by ID",
            description = "Get user by ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public UserDto getUserById(@Parameter(description = "User id", required = true) @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        return userService.getUserById(id, userDetails.getUsername());
    }

    @Operation(
            summary = "Get user friends",
            description = "Get user friends"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/friends/page={pageNum}")
    public Page<UserDto> getFriendsByUser(@PathVariable("pageNum") int pageNum,
          @AuthenticationPrincipal UserDetails userDetails) {
        return userService.getFriendsByUserId(userDetails.getUsername(), pageNum);
    }

    @Operation(
            summary = "Get users by keyword",
            description = "Get users by keyword"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{keywordValue}/page={pageNum}")
    public Page<UserDto> getUsersByKeyword(
            @PathVariable String keywordValue,
            @PathVariable int pageNum) {
        return userService.getUsersByKeyword(keywordValue, pageNum);
    }
}
