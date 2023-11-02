package com.example.reportservice.service;

import com.example.reportservice.data.InvitationStatisticRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JmsService {

    private final StatisticService statisticService;

    @JmsListener(destination = "cupid-link")
    public void receiveAndForwardMessageFromQueue(
          @Payload InvitationStatisticRequest invitationStatisticRequest) {
        statisticService.updateStatistic(invitationStatisticRequest);
    }
}

