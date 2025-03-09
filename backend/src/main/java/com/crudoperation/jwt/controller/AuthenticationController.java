package com.crudoperation.jwt.controller;

import com.crudoperation.jwt.dto.AuthenticationDto;
import com.crudoperation.jwt.dto.ResponseDto;
import com.crudoperation.jwt.entity.AuthenticationResponse;
import com.crudoperation.jwt.entity.UserAccount;
import com.crudoperation.jwt.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto>register(@RequestBody UserAccount request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto>login(@RequestBody UserAccount request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
