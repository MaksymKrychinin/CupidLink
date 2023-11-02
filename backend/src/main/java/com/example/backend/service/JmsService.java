package com.example.backend.service;

import com.example.backend.data.dto.InvitationStatisticRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JmsService {

    @Value("${spring.activemq.queue}")
    private String queue;

    private final JmsTemplate jmsTemplate;

    public void sendToQueue(InvitationStatisticRequest invitationStatisticRequest) {
        jmsTemplate.convertAndSend(queue, invitationStatisticRequest);
    }
}

