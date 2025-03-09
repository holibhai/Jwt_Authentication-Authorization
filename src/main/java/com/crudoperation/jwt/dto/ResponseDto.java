package com.crudoperation.jwt.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
        private AuthenticationDto authenticationDto;
        private UserAccountDto userAccountDto;
        private String statusCode;
        private String statusMessage;

    public ResponseDto(AuthenticationDto authenticationDto, UserAccountDto userAccountDto, String statusCode, String statusMessage) {
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

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
