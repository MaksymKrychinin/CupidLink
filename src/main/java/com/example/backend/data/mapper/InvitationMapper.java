package com.example.backend.data.mapper;

import com.example.backend.data.dto.InvitationDto;
import com.example.backend.data.entity.Invitation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface InvitationMapper {

    Invitation toInvitation(InvitationDto invitationDto);

    @Mappings({@Mapping(source = "sender", target = "sender"),
            @Mapping(source = "receiver", target = "receiver")})
    InvitationDto toInvitationDto(Invitation invitation);
}
