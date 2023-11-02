package com.example.backend.data.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private OpenInfo openInfo;
    @OneToOne(cascade = CascadeType.ALL)
    private SecretInfo secretInfo;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_keywords",
            joinColumns = @JoinColumn(name = "keyword_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Keyword> keywords;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> friends;
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private Set<Invitation> sentInvitations;
    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
    private Set<Invitation> receivedInvitations;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(() -> "USER");
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
