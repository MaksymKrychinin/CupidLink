package com.example.backend.service;

import com.example.backend.entity.Friend;
import com.example.backend.entity.User;
import com.example.backend.exception.ValidationException;
import com.example.backend.repository.FriendRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;

    public void addFriend(User currentUser, Long id) {
        if (currentUser.getId().equals(id)) {
            throw ValidationException.builder()
                    .message("You can't add yourself")
                    .httpStatus(HttpStatus.BAD_REQUEST).build();
        }
        if (friendRepository.existsByUserThatSentRequest_IdAndUserThatReceivedRequest_Id(currentUser.getId(), id)) {
            throw ValidationException.builder()
                    .message("You have already sent a friend request to this user")
                    .httpStatus(HttpStatus.BAD_REQUEST).build();
        }
        Friend friend = Friend.builder()
                .userThatSentRequest(currentUser)
                .userThatReceivedRequest(userRepository.findById(id).orElseThrow(
                        () -> ValidationException.builder()
                                .message("User with id " + id + " not found")
                                .httpStatus(HttpStatus.NOT_FOUND).build())).build();
        friendRepository.save(friend);
    }
}
