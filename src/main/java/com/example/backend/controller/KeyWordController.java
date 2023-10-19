package com.example.backend.controller;

import com.example.backend.data.dto.KeywordDto;
import com.example.backend.service.KeyWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/keyword")
@RequiredArgsConstructor
public class KeyWordController {
    private final KeyWordService keyWordService;

    @PostMapping("")
    public void createKeyword(KeywordDto keyWordDto) {
        keyWordService.createKeyword(keyWordDto);
    }
}
