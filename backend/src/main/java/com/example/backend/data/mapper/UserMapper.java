package com.example.backend.data.mapper;

import com.example.backend.data.dto.RegisterRequest;
import com.example.backend.data.dto.UserDto;
import com.example.backend.data.entity.User;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {OpenInfoMapper.class, SecretInfoMapper.class,
      KeywordMapper.class})
public interface UserMapper {

    User toUser(UserDto userDto);

    User toUserFromRegister(RegisterRequest request);

    @MapUserToUserDto
    @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "openInfo", target = "openInfo"),
          @Mapping(source = "keywords", target = "keywords"),
          @Mapping(target = "secretInfo", ignore = true)})
    UserDto toUserDto(User user);

    UserDto toUserDtoWithSecretInfo(User user);
    Set<UserDto> toUserDtoSet(Set<User> users);
}
