package com.example.backend.data.mapper;

import com.example.backend.data.dto.OpenInfoDto;
import com.example.backend.data.entity.OpenInfo;
import org.mapstruct.Mapper;

@Mapper
public interface OpenInfoMapper {
    OpenInfo toOpenInfo(OpenInfoDto openInfoDto);
    OpenInfoDto toOpenInfoDto(OpenInfo openInfo);
}
