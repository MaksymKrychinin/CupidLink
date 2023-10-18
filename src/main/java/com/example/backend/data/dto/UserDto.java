package com.example.backend.data.dto;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private OpenInfoDto openInfo;
    private Set<KeyWordDto> keyWords;
}
