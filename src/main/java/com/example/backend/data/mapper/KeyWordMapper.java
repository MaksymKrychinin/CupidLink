package com.example.backend.data.mapper;

import com.example.backend.data.dto.KeyWordDto;
import com.example.backend.data.entity.KeyWord;
import org.mapstruct.Mapper;

@Mapper
public interface KeyWordMapper {

    KeyWord toKeyWord(KeyWordDto keyWordDto);

    KeyWordDto toKeyWordDto(KeyWord keyWord);
}
