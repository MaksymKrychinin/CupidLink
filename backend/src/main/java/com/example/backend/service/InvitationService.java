package com.example.backend.service;

import com.example.backend.data.dto.InvitationDto;
import com.example.backend.data.dto.InvitationStatisticRequest;
import com.example.backend.data.entity.Invitation;
import com.example.backend.data.entity.User;
import com.example.backend.data.mapper.InvitationMapper;
import com.example.backend.repository.InvitationRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvitationService {

    @Value("${page-size-for-invitations}")
    protected int PAGE_SIZE_FOR_INVITATIONS;

    private final InvitationMapper invitationMapper;
    private final InvitationRepository invitationRepository;
    private final UserService userService;
    private final JmsService jmsService;

    public Page<InvitationDto> getSentInvitationsBySenderId(Long id, int pageNum) {
        return invitationRepository.getBySenderId(id, createPageRequest(pageNum))
              .map(invitationMapper::toInvitationDto);
    }

    public Page<InvitationDto> getSentInvitationsByReceiverId(Long id, int pageNum) {
        return invitationRepository.getByReceiverId(id, createPageRequest(pageNum))
              .map(invitationMapper::toInvitationDto);
    }

    public void sendInvitation(InvitationDto invitationDto) {
        if (userService.isFriends(invitationDto.getSender().getId(),
              invitationDto.getReceiver().getId())) {
            throw new IllegalArgumentException("Users are already friends");
        }
        jmsService.sendToQueue(new InvitationStatisticRequest(invitationDto.getReceiver().getId(),
              invitationDto.getSentDateTime()));
        invitationRepository.save(invitationMapper.toInvitation(invitationDto));
    }

    public void deleteInvitation(Long id, Long currentUserId) {
        Invitation invitation = invitationRepository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException(
                    "Invitation with such id does not exist: " + id));

        if (!invitation.getSender().getId().equals(currentUserId) || !invitation.getReceiver()
              .getId().equals(currentUserId)) {
            throw new IllegalArgumentException("You are not allowed to delete this invitation");
        }
        invitationRepository.deleteById(id);
    }


    private PageRequest createPageRequest(int page) {
        Sort sort = Sort.by(Sort.Order.desc("id"));
        return PageRequest.of(page - 1, PAGE_SIZE_FOR_INVITATIONS, sort);
    }
}
