package com.example.backend.controller;

import com.example.backend.data.dto.InvitationDto;
import com.example.backend.service.InvitationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invitation")
@RequiredArgsConstructor
public class InvitationController {
    private final InvitationService invitationService;

    @GetMapping("/bySender/{id}/page={pageNum}")
    public Page<InvitationDto> getSentInvitationsBySenderId(
            @PathVariable Long id,
            @PathVariable Integer pageNum) {
        return invitationService.getSentInvitationsBySenderId(id, pageNum);
    }

    @GetMapping("/byReceiver/{id}/page={pageNum}")
    public Page<InvitationDto> getSentInvitationsByReceiverId(
            @PathVariable("id") Long id,
            @PathVariable("pageNum") Integer pageNum) {
        return invitationService.getSentInvitationsByReceiverId(id, pageNum);
    }

    @Operation(
            summary = "Send invitation to",
            description = "Send invitation to"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/")
    public void sendInvitation(@RequestBody InvitationDto invitationDto) {
        invitationService.sendInvitation(invitationDto);
    }

    @Operation(
            summary = "Delete Invitation by ID",
            description = "Delete Invitation by ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteInvitation(@PathVariable Long id, Long currentUserId) {
        invitationService.deleteInvitation(id, currentUserId);
    }
}
