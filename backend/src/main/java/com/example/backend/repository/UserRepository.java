package com.example.backend.repository;

import com.example.backend.data.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @Transactional
    <S extends User> S save(S entity);

    Optional<User> findUserById(Long id);

    Page<User> getFriendsById(Long id, Pageable pageable);

    @Query("select u.users from key_words u where u.value like concat('%', ?1, '%')")
    Page<User> findUserByKeywordsContains(String value, Pageable pageable);

}
