package com.example.backend.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private OpenInfoDto openInfo;
    @JsonInclude(Include.NON_NULL)
    private SecretInfoDto secretInfo;
    private Set<KeywordDto> keywords;
}
