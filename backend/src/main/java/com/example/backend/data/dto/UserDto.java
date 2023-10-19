package com.example.backend.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private OpenInfoDto openInfo;
    @JsonInclude(Include.NON_NULL)
    private SecretInfoDto secretInfo;
    private Set<KeywordDto> keywords;
}
