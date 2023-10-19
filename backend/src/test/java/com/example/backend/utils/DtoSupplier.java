package com.example.backend.utils;

import com.example.backend.data.dto.KeywordDto;
import com.example.backend.data.dto.OpenInfoDto;
import com.example.backend.data.dto.UserDto;
import java.util.Set;

public class DtoSupplier {

    public static OpenInfoDto createOpenInfoDto() {
        return OpenInfoDto.builder()
              .id(1L)
              .firstName("John")
              .lastName("Doe")
              .location("London")
              .description("I am a software engineer")
              .build();
    }

    public static KeywordDto createKeyWordDto() {
        return KeywordDto.builder()
              .id(1L)
              .value("Java")
              .build();
    }

    public static UserDto createUserDto() {
        return UserDto.builder()
              .id(1L)
              .openInfo(createOpenInfoDto())
              .keywords(Set.of(createKeyWordDto()))
              .build();
    }
}
