package com.example.backend.controller;

import com.example.backend.data.dto.InvitationDto;
import com.example.backend.service.InvitationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invitation")
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @Operation(
          summary = "Get send invitations",
          description = "Get send invitations"
    )
    @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
          @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
          @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/bySender/page={pageNum}")
    public Page<InvitationDto> getSentInvitationsBySender(@PathVariable Integer pageNum,
          @AuthenticationPrincipal UserDetails userDetails) {
        return invitationService.getSentInvitationsBySenderUsername(userDetails.getUsername(),
              pageNum);
    }

    @Operation(
          summary = "Get received invitations",
          description = "Get received invitations"
    )
    @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
          @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
          @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/byReceiver/page={pageNum}")
    public Page<InvitationDto> getSentInvitationsByReceiverId(
          @PathVariable("pageNum") Integer pageNum,
          @AuthenticationPrincipal UserDetails userDetails) {
        return invitationService.getSentInvitationsByReceiverUsername(userDetails.getUsername(),
              pageNum);
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
    public void sendInvitation(
          @Parameter(description = "Invitation info", required = true) @RequestBody InvitationDto invitationDto,
          @AuthenticationPrincipal UserDetails userDetails) {
        invitationService.sendInvitation(invitationDto, userDetails);
    }

    @Operation(
          summary = "Delete Invitation by id",
          description = "Delete Invitation by id"
    )
    @ApiResponses({
          @ApiResponse(responseCode = "204", description = "Successfully retrieved"),
          @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
          @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteInvitation(
          @Parameter(description = "Invitation id", required = true) @PathVariable Long id,
          @AuthenticationPrincipal UserDetails userDetails) {
        invitationService.deleteInvitation(id, userDetails.getUsername());
    }

    @Operation(
          summary = "Accept Invitation by id",
          description = "Accept Invitation by id"
    )
    @ApiResponses({
          @ApiResponse(responseCode = "204", description = "Successfully retrieved"),
          @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
          @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping("/{invitationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void acceptInvitation(
          @Parameter(description = "Invitation id", required = true) @PathVariable Long invitationId,
          @AuthenticationPrincipal UserDetails userDetails) {
        invitationService.acceptInvitation(invitationId, userDetails.getUsername());
    }
}
