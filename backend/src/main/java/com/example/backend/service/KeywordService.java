package com.example.backend.service;

import com.example.backend.data.entity.Keyword;
import com.example.backend.repository.KeywordRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keyWordRepository;

    public List<Keyword> getKeywords() {
        return keyWordRepository.findAll();
    }

}
