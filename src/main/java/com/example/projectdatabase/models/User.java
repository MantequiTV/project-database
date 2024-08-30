package com.example.projectdatabase.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user")
// Using Lombok as an alternative to filling out getters and setters
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String surname;
    private String company;

    // Need to specify that we want MariaDB's TinyInt(1) approach to Bools.
    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private Boolean enabled;
}