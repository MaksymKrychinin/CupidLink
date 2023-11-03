package com.example.backend.repository;

import com.example.backend.data.entity.Keyword;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    Keyword save(Keyword keyword);

    List<Keyword> findAll();
}
