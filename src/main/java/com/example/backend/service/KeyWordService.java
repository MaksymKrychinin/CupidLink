package com.example.backend.service;

import com.example.backend.data.dto.KeyWordDto;
import com.example.backend.data.mapper.KeyWordMapper;
import com.example.backend.repository.KeyWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeyWordService {

    private final KeyWordRepository keyWordRepository;
    private final KeyWordMapper keyWordMapper;

    public KeyWordDto getKeyWordByValue(String value) {
        return keyWordRepository.findByValue(value)
              .map(keyWordMapper::toKeyWordDto)
              .orElseThrow(() -> new IllegalArgumentException(
                    "KeyWord with such value does not exist: " + value));
    }

}
