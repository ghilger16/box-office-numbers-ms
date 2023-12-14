package com.boxofficenumbers.api.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<UserSelectionDto> selectionList;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}



