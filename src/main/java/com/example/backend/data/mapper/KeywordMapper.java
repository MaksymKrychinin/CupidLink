package com.example.backend.data.mapper;

import com.example.backend.data.dto.KeywordDto;
import com.example.backend.data.entity.Keyword;
import org.mapstruct.Mapper;

@Mapper
public interface KeywordMapper {

    Keyword toKeyWord(KeywordDto keyWordDto);

    KeywordDto toKeyWordDto(Keyword keyWord);
}
