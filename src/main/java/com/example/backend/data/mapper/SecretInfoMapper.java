package com.example.backend.data.mapper;

import com.example.backend.data.dto.SecretInfoDto;
import com.example.backend.data.entity.SecretInfo;
import org.mapstruct.Mapper;

@Mapper
public interface SecretInfoMapper {
    SecretInfo toSecretInfo(SecretInfoDto secretInfoDto);
    SecretInfoDto toSecretInfoDto(SecretInfo secretInfo);
}
