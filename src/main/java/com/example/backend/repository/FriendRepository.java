package com.example.backend.repository;

import com.example.backend.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long>{
    boolean existsByUserThatSentRequest_IdAndUserThatReceivedRequest_Id(Long id, Long id1);

}
