package com.example.backend.service;

import com.example.backend.data.dto.KeywordDto;
import com.example.backend.data.mapper.KeywordMapper;
import com.example.backend.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keyWordRepository;
    private final KeywordMapper keywordMapper;

    public void createKeyword(KeywordDto keyWordDto) {
        keyWordRepository.save(keywordMapper.toKeyWord(keyWordDto));
    }

}
