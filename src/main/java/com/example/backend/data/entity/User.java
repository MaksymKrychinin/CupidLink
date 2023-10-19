package com.example.backend.data.entity;

import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
    @OneToOne
    private OpenInfo openInfo;
    @OneToOne
    private SecretInfo secretInfo;
    @ManyToMany
    @JoinTable(
          name = "key_words",
          joinColumns = @JoinColumn(name = "id"),
          inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Keyword> keywords;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> friends;
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private Set<Invitation> sentInvitations;
    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
    private Set<Invitation> receivedInvitations;
}
