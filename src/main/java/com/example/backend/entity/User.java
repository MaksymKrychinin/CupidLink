package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false, unique = true, length = 32)
    @NotNull
    private String username;

    @Column(name = "password", nullable = false, length = 64)
    @NotNull
    private String password;

    @Column(name = "email", nullable = false, unique = true, length = 64)
    @NotNull
    private String email;

    @Column(name = "first_name", nullable = false, length = 32)
    @NotNull
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 32)
    @NotNull
    private String lastName;
}
