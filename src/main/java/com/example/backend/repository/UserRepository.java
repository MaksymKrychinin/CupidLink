package com.example.backend.repository;

import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("""
            update User u set u.username = ?1, u.password = ?2, u.email = ?3,
            u.firstName = ?4, u.lastName = ?5
            where u.id = ?6""")
    void updateUserInfoById(String username, String password, String email,
                           String firstName, String lastName, Long id);
    User findByUsername(String username);

    @Query("SELECT u FROM User u " +
            "WHERE u.firstName in :keywords " +
            "or u.lastName in :keywords " +
            "or u.email in :keywords")
   List<User> findAllByKeywords(@Param("keywords") List<String> keywords);
}