package com.example.backend.controller;

import com.example.backend.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/friends")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @PostMapping("/add/{id}")
    public ResponseEntity<Void> addFriend(@PathVariable Long id) {
        friendService.addFriend(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
