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
    @OneToOne(cascade = CascadeType.ALL)
    private OpenInfo openInfo;
    @OneToOne(cascade = CascadeType.ALL)
    private SecretInfo secretInfo;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
          name = "user_keywords",
          joinColumns = @JoinColumn(name = "keyword_id"),
          inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Keyword> keywords;
    @JoinTable(
            name = "friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> friends;
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private Set<Invitation> sentInvitations;
    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
    private Set<Invitation> receivedInvitations;
}
