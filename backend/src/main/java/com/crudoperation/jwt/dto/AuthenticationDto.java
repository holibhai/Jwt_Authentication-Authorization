package com.crudoperation.jwt.dto;

public class AuthenticationDto {
    private String token;

    public AuthenticationDto(String token) {
        this.token = token;
    }

    public AuthenticationDto() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

