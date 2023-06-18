package com.boxofficenumbers.api.dto;

public class LoginResponseDto {
    private String userName;
    private String authToken;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String userName, String authToken) {
        this.userName = userName;
        this.authToken = authToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
