package com.example.backend.repository;

import com.example.backend.data.entity.Keyword;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends PagingAndSortingRepository<Keyword, Long> {

    void save(Keyword keyword);
}
