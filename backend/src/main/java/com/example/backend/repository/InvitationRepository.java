package com.example.backend.repository;

import com.example.backend.data.entity.Invitation;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    Page<Invitation> getBySenderUsername(String username, Pageable pageable);

    List<Invitation> getBySenderId(Long id);

    Page<Invitation> getByReceiverUsername(String username, Pageable pageable);

    List<Invitation> getByReceiverId(Long id);
    Optional<Invitation>getBySenderIdAndReceiverId(Long senderId, Long receiverId);

    Invitation getById(Long id);

    Invitation save(Invitation invitation);

    void deleteById(Long id);
}
