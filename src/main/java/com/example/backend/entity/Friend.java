package com.example.backend.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Table(name = "friend")
@Setter
@Getter
@Builder
public class Friend {

    @ManyToOne
    @JoinColumn(name = "user_that_sent_request")
    User userThatSentRequest;
    @ManyToOne
    @JoinColumn(name = "user_that_received_request")
    User userThatReceivedRequest;

}
