package com.boxofficenumbers.api.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    // other fields and methods

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}



