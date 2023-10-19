package com.example.backend.controller;

import com.example.backend.data.dto.InvitationDto;
import com.example.backend.service.InvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invitation")
@RequiredArgsConstructor
public class InvitationController {
    private final InvitationService invitationService;

    @GetMapping("/{id}/page={pageNum}")
    public Page<InvitationDto> getSentInvitationsBySenderId(@PathVariable Long id,@PathVariable int pageNum) {
        return invitationService.getSentInvitationsBySenderId(id, pageNum);
    }

    @GetMapping("/{id}/page={pageNum}")
    public Page<InvitationDto> getSentInvitationsByReceiverId(@PathVariable("id") Long id, @PathVariable("pageNum") int pageNum) {
        return invitationService.getSentInvitationsByReceiverId(id, pageNum);
    }

    @PostMapping
    public void sendInvitation(InvitationDto invitationDto) {
        invitationService.sendInvitation(invitationDto);
    }

    @DeleteMapping
    public void deleteInvitation(Long id, Long currentUserId) {
        invitationService.deleteInvitation(id, currentUserId);
    }
}
