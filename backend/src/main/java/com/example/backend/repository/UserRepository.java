package com.example.backend.repository;

import com.example.backend.data.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> save(User user);

    Optional<User> findUserById(Long id);

    Page<User> getFriendsById(Long id, Pageable pageable);

    @Query("select u.users from key_words u where u.value like concat('%', ?1, '%')")
    Page<User> findUserByKeywordsContains(String value, Pageable pageable);

    boolean userWithIdIsFriendOfUserWithId(Long userId, Long friendId);

    void saveAll(List<User> users);
}
