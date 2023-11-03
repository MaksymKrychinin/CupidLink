package com.example.backend.repository;

import com.example.backend.data.entity.Keyword;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    Keyword save(Keyword keyword);

    Optional<Keyword> findByValue(String value);
    List<Keyword> findAll();
}
