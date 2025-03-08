package com.crudoperation.jwt.controller;

import com.crudoperation.jwt.entity.AuthenticationResponse;
import com.crudoperation.jwt.entity.UserAccount;
import com.crudoperation.jwt.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody UserAccount request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>login(@RequestBody UserAccount request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
