package com.example.backend.controller;

import com.example.backend.entity.User;
import com.example.backend.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/friends")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @PostMapping("/add/{id}")
    public ResponseEntity<Void> addFriend(@RequestBody User currentUser, @PathVariable Long id) {
        friendService.addFriend(currentUser, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
