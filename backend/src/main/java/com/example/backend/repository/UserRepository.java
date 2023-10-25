package com.example.backend.repository;

import com.example.backend.data.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    User save(User entity);

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserById(Long id);

    Page<User> getFriendsById(Long id, Pageable pageable);

    @Query("select u.users from key_words u where u.value like concat('%', ?1, '%')")
    Page<User> findUserByKeywordsContains(String value, Pageable pageable);


    @Query("select (count(u) > 0) from users u where u.id = ?1 and ?2 in (select f.id from u.friends f)")
    boolean userWithIdIsFriendOfUserWithId(Long userId, Long friendId);


    @Override
    <S extends User> List<S> saveAll(Iterable<S> entities);
}
