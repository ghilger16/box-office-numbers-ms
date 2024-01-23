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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<UserSelectionDto> getSelectionList() {
//        return selectionList;
//    }
//
//    public void setSelectionList(List<UserSelectionDto> selectionList) {
//        this.selectionList = selectionList;
//    }
}
