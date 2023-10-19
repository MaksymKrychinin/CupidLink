package com.example.backend.service;

import com.example.backend.data.dto.UserDto;
import com.example.backend.data.entity.User;
import com.example.backend.data.mapper.UserMapper;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${page-size}")
    protected static int PAGE_SIZE = 10;

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void createUser(UserDto userDto) {
        userRepository.save(userMapper.toUser(userDto));
    }

    public UserDto getUserById(Long id, Long currentUserId) {
        return userRepository.findById(id)
                .map(user -> retrieveUser(user, currentUserId))
                .orElseThrow(() -> new IllegalArgumentException(
                        "User with such id does not exist: " + id));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "User with such id does not exist: " + id));
    }

    private UserDto retrieveUser(User user, Long currentUserId) {
        User currentUser = userRepository.findById(currentUserId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "User with such id does not exist: " + currentUserId));

        if (user.getFriends().contains(currentUser)) {
            return userMapper.toUserDtoWithSecretInfo(user);
        } else {
            return userMapper.toUserDto(user);
        }
    }

    public Page<UserDto> getFriendsByUserId(Long id, int pageNum) {
        return userRepository.getFriendsById(id, createPageRequest(pageNum))
                .map(userMapper::toUserDto);

    }

    public Page<UserDto> getUsersByKeyword(String keywordValue, int pageNum) {
        return userRepository.findUserByKeywordsContains(keywordValue, createPageRequest(pageNum))
                .map(userMapper::toUserDto);
    }

    public boolean isFriends(Long userId, Long friendId) {
        return userRepository.userWithIdIsFriendOfUserWithId(userId, friendId);
    }

    private PageRequest createPageRequest(int page) {
        return PageRequest.of(page - 1, UserService.PAGE_SIZE);
    }

}
