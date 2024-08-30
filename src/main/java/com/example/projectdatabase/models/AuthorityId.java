package com.example.projectdatabase.models;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class AuthorityId {
    private String username;
    private String authority;

    public AuthorityId(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }
}