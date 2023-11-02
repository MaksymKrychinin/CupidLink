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

    Page<Invitation> getBySenderId(Long id, Pageable pageable);

    List<Invitation> getBySenderId(Long id);

    Page<Invitation> getByReceiverId(Long id, Pageable pageable);

    @Query("select inv.receiverId from Invitation inv where inv.id=?")
    Long getReceiverId(Long id);


    Invitation getById(Long id);

    Invitation save(Invitation invitation);

    void deleteById(Long id);
}
