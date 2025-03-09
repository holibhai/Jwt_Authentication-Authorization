package com.crudoperation.jwt.service;

import com.crudoperation.jwt.dto.AuthenticationDto;
import com.crudoperation.jwt.dto.ResponseDto;
import com.crudoperation.jwt.dto.UserAccountDto;
import com.crudoperation.jwt.entity.AuthenticationResponse;
import com.crudoperation.jwt.entity.UserAccount;
import com.crudoperation.jwt.repository.UserRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.crudoperation.jwt.utility.MapUtils;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtSerivice jwtSerivice;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtSerivice jwtSerivice, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtSerivice = jwtSerivice;
        this.authenticationManager = authenticationManager;
    }

    public ResponseDto register(UserAccount request ){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(request.getUsername());
        userAccount.setPassword(passwordEncoder.encode(request.getPassword()));
        userAccount.setFirstName(request.getFirstName());
        userAccount.setLastName(request.getLastName());
        userAccount.setRole(request.getRole());


        userAccount=userRepository.save(userAccount);
        UserAccountDto userAccountDto= MapUtils.mapUserEntityToUserAccountDto(userAccount);
        String token = jwtSerivice.generateToken(userAccount);

        AuthenticationDto authenticationDto=new AuthenticationDto(token);
        ResponseDto responseDto=new ResponseDto();
        responseDto.setAuthenticationDto(authenticationDto);
        responseDto.setUserAccountDto(userAccountDto);
        responseDto.setStatusCode(200);
        responseDto.setStatusMessage("successfully registered");

        return responseDto;
    }

    public ResponseDto authenticate(UserAccount request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        UserAccount user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtSerivice.generateToken(user);
        AuthenticationDto authenticationDto=new AuthenticationDto(token);
        UserAccountDto userAccountDto= MapUtils.mapUserEntityToUserAccountDto(user);
        ResponseDto responseDto=new ResponseDto();
        responseDto.setAuthenticationDto(authenticationDto);
        responseDto.setUserAccountDto(userAccountDto);
        responseDto.setStatusCode(200);
        responseDto.setStatusMessage("successfully authenticated");

        return responseDto;

    }
}
