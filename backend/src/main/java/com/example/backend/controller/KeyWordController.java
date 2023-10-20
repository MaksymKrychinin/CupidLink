package com.example.backend.controller;

import com.example.backend.data.dto.KeywordDto;
import com.example.backend.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/keyword")
@RequiredArgsConstructor
public class KeyWordController {
    private final KeywordService keyWordService;

    @PostMapping("")
    public void createKeyword(@RequestBody KeywordDto keyWordDto) {
        keyWordService.createKeyword(keyWordDto);
    }
}
