package com.crudoperation.jwt.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
        private AuthenticationDto authenticationDto;
        private UserAccountDto userAccountDto;
        private int statusCode;
        private String statusMessage;

    public ResponseDto(AuthenticationDto authenticationDto, UserAccountDto userAccountDto, int statusCode, String statusMessage) {
        this.authenticationDto = authenticationDto;
        this.userAccountDto = userAccountDto;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public ResponseDto() {

    }

    public AuthenticationDto getAuthenticationDto() {
        return authenticationDto;
    }

    public void setAuthenticationDto(AuthenticationDto authenticationDto) {
        this.authenticationDto = authenticationDto;
    }

    public UserAccountDto getUserAccountDto() {
        return userAccountDto;
    }

    public void setUserAccountDto(UserAccountDto userAccountDto) {
        this.userAccountDto = userAccountDto;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
