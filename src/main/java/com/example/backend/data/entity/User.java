package com.example.backend.data.entity;

import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
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
    private Set<KeyWord> keyWords;
    @ManyToMany
    private Set<User> friends;
    @OneToMany(mappedBy = "sender")
    private Set<Invitation> sentInvitations;

    @OneToMany(mappedBy = "receiver")
    private Set<Invitation> receivedInvitations;
}
