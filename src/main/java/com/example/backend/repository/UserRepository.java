package com.example.backend.repository;

import com.example.backend.data.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    void save(User user);

    Optional<User> getById(Long id);

    Page<User> getFriendsById(Long id, Pageable pageable);

    Page<User> getUsersByKeywordValue(String value, Pageable pageable);

    boolean userWithIdIsFriendOfUserWithId(Long userId, Long friendId);
}
