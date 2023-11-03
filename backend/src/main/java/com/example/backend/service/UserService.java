package com.example.backend.service;

import com.example.backend.data.dto.UserDto;
import com.example.backend.data.entity.Keyword;
import com.example.backend.data.entity.User;
import com.example.backend.data.exception.UserProcessingException;
import com.example.backend.data.mapper.UserMapper;
import com.example.backend.repository.InvitationRepository;
import com.example.backend.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${page-size}")
    protected int PAGE_SIZE;

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KeywordService keywordService;
    private final InvitationRepository invitationRepository;

    public void createUser(User user) {
        Set<Keyword> userKeywords = user.getKeywords();
        List<Keyword> applicationKeywords = keywordService.getKeywords();
        userKeywords.forEach(userKeyword -> {
            Optional<Keyword> matchingKeyword = applicationKeywords
                  .stream()
                  .filter(appKeyword -> appKeyword.getValue().equals(userKeyword.getValue()))
                  .findFirst();

            matchingKeyword.ifPresent(match -> userKeyword.setId(match.getId()));
        });
        user.setKeywords(userKeywords);
        userRepository.save(user);
    }

    public UserDto getUserById(Long id, String currentUserUsername) {
        return userRepository.findById(id)
              .map(user -> retrieveUser(user, currentUserUsername))
              .orElseThrow(() -> new UserProcessingException(
                    "User with such id does not exist: " + id));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
              .orElseThrow(() -> new UserProcessingException(
                    "User with such id does not exist: " + id));
    }

    private UserDto retrieveUser(User user, String currentUserUsername) {
        User currentUser = userRepository.findUserByUsername(currentUserUsername)
              .orElseThrow(() -> new UserProcessingException(
                    "User with such id does not exist: " + currentUserUsername));

        System.out.println(invitationRepository.getByReceiverId(currentUser.getId()));
        if (invitationRepository.getBySenderIdAndReceiverId(user.getId(), currentUser.getId())
              .isPresent()) {
            return userMapper.toUserDtoWithSecretInfo(user);
        }
        return userMapper.toUserDto(user);

    }

    public Page<UserDto> getFriendsByUserId(String username, int pageNum) {
        return userRepository.getFriendsByUsername(username, createPageRequest(pageNum))
              .map(userMapper::toUserDto);

    }

    public Page<UserDto> getUsersByKeyword(String keywordValue, int pageNum) {
        return userRepository.findUserByKeywordsContains(keywordValue, createPageRequest(pageNum))
              .map(userMapper::toUserDto);
    }

    public boolean isFriends(Long userId, Long friendId) {
        return userRepository.findUserById(userId)
              .map(user -> user.getFriends().stream()
                    .anyMatch(friend -> friend.getId().equals(friendId)))
              .orElseThrow(() -> new UserProcessingException(
                    "User with such id does not exist: " + userId));
    }

    public Long getUserIdByUsername(String username) {
        return userRepository.findUserByUsername(username)
              .map(User::getId)
              .orElseThrow(() -> new UserProcessingException(
                    "User with such username does not exist: " + username));
    }

    private PageRequest createPageRequest(int page) {
        return PageRequest.of(page - 1, PAGE_SIZE);
    }

}
