package com.example.backend.repository;

import com.example.backend.data.entity.Invitation;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends PagingAndSortingRepository<Invitation, Long> {

    Page<Invitation> getBySenderId(Long id, Pageable pageable);

    Page<Invitation> getByReceiverId(Long id, Pageable pageable);

    Optional<Invitation> getById(Long id);

    void save(Invitation invitation);

    void deleteById(Long id);
}
