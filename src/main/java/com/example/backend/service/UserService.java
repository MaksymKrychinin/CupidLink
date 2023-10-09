package com.example.backend.service;

import com.example.backend.entity.User;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.FriendRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

    public void update(User userUpdates, Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> NotFoundException.builder()
                        .message("User not found")
                        .httpStatus(HttpStatus.NOT_FOUND).build());
        userRepository.updateUserInfoById(
                userUpdates.getUsername(),
                userUpdates.getPassword(),
                userUpdates.getEmail(),
                userUpdates.getFirstName(),
                userUpdates.getLastName(), id);
    }

    public User findById(User currentUser, Long idOfFindUser) {
        if (currentUser.getId().equals(idOfFindUser)) {
            return currentUser;
        }
        User user = userRepository.findById(idOfFindUser)
                .orElseThrow(() -> NotFoundException.builder()
                        .message("User not found")
                        .httpStatus(HttpStatus.NOT_FOUND).build());
        if (!friendRepository
                .existsByUserThatSentRequest_IdAndUserThatReceivedRequest_Id(
                        user.getId(), currentUser.getId())) {
            user.setEmail(null);
        }
        return user;
    }

    public List<User> findByKeyword(String keyword) {
        List<String> splitedList = Arrays.stream(keyword.split(",")).toList();
        return userRepository.findAllByKeywords(splitedList);
    }
}
