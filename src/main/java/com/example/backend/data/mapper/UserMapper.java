package com.example.backend.data.mapper;

import com.example.backend.data.dto.UserDto;
import com.example.backend.data.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toUser(UserDto userDto);
    UserDto toUserDto(User user);
}
