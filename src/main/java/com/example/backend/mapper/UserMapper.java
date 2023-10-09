package com.example.backend.mapper;

import com.example.backend.dto.RegistrationRequest;
import com.example.backend.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToUser(RegistrationRequest registrationRequest);
}
