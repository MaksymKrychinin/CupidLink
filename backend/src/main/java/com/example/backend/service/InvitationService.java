package com.example.backend.service;

import com.example.backend.data.dto.InvitationDto;
import com.example.backend.data.dto.InvitationStatisticRequest;
import com.example.backend.data.dto.UserDto;
import com.example.backend.data.entity.Invitation;
import com.example.backend.data.entity.User;
import com.example.backend.data.mapper.InvitationMapper;
import com.example.backend.repository.InvitationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Transactional
    public void sendInvitation(InvitationDto invitationDto, UserDetails userDetails) {
        Long currentUserId = userService.getUserIdByUsername(userDetails.getUsername());
        if (userService.isFriends(currentUserId, invitationDto.getReceiver().getId())) {
            throw new IllegalArgumentException("Users are already friends");
        }
        if (invitationRepository.getBySenderId(currentUserId).stream()
              .anyMatch(invitation -> invitation.getReceiver().getId()
                    .equals(invitationDto.getReceiver().getId()))) {
            throw new IllegalArgumentException("Invitation has already been sent");
        }
        invitationDto.setSender(new UserDto().builder().id(currentUserId).build());
        invitationRepository.save(invitationMapper.toInvitation(invitationDto));
        /*jmsService.sendToQueue(new InvitationStatisticRequest(invitationDto.getReceiver().g,
              invitationDto.getSentDateTime()));*/
    }

    @Transactional
    public void acceptInvitation(Long id, String username) {
        Invitation invitation = invitationRepository.getById(id);
        String receiverUsername = invitation.getReceiver().getUsername();

        if (!receiverUsername.equals(username)) {
            throw new IllegalArgumentException("You are not allowed to accept this invitation");
        }

        User sender = userService.getUserById(invitation.getSender().getId());
        User receiver = userService.getUserById(invitation.getReceiver().getId());

        /*invitationRepository.deleteById(id);

        sender.getFriends().add(receiver);
        receiver.getFriends().add(sender);*/
        System.out.println("UDHFUDHFUHDF");

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
