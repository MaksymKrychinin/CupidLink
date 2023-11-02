package com.example.backend.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "invitations")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;
    private String message;
    private LocalDateTime sentDateTime;

    @Override
    public String toString() {
        return "Invitation{" +
              "id=" + id +
              ", sender=" + sender +
              ", receiver=" + receiver +
              ", message='" + message + '\'' +
              ", sentDateTime=" + sentDateTime +
              '}';
    }
}
