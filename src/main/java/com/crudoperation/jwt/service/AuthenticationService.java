package com.crudoperation.jwt.service;

import com.crudoperation.jwt.entity.AuthenticationResponse;
import com.crudoperation.jwt.entity.UserAccount;
import com.crudoperation.jwt.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtSerivice jwtSerivice;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtSerivice jwtSerivice) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtSerivice = jwtSerivice;
    }

    public AuthenticationResponse register(UserAccount request ){
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(request.getFirstName());
        userAccount.setLastName(request.getLastName());
        userAccount.setUsername(request.getUsername());
        userAccount.setPassword(passwordEncoder.encode(request.getPassword()));
        userAccount.setRole(request.getRole());

        userAccount=userRepository.save(userAccount);
        String token = jwtSerivice.generateToken(userAccount);
        return new AuthenticationResponse(token);
    }
}
