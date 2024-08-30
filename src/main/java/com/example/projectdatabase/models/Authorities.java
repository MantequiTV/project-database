package com.example.projectdatabase.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "authorities")
@Getter @Setter @NoArgsConstructor
@IdClass(AuthorityId.class)
public class Authorities {
    @Id
    String username;
    @Id
    String authority;
}