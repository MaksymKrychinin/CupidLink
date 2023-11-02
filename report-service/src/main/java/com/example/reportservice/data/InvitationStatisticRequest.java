package com.example.reportservice.data;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvitationStatisticRequest {
    private String username;
    private LocalDateTime date;
}
