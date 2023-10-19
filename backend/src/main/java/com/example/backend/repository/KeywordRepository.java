package com.example.backend.repository;

import com.example.backend.data.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    Keyword save(Keyword keyword);
}
