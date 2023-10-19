package com.example.backend.service;

import com.example.backend.data.dto.KeywordDto;
import com.example.backend.data.mapper.KeywordMapper;
import com.example.backend.repository.KeyWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeyWordService {

    private final KeyWordRepository keyWordRepository;
    private final KeywordMapper keywordMapper;

    public void createKeyword(KeywordDto keyWordDto) {
        keyWordRepository.save(keywordMapper.toKeyWord(keyWordDto));
    }

}
