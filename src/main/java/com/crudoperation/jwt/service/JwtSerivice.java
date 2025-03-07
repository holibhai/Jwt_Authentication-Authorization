package com.crudoperation.jwt.service;

import com.crudoperation.jwt.entity.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtSerivice {
    private final String SECRET_KEY = "d96c7635737d4d281d62758c8c87b65140ea20bcf9c3980510f941a594b1c7aa";

    public String generateToken(UserAccount userAccount) {
        String token = Jwts
                .builder()
                .setSubject(userAccount.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(getSigninKey())
                .compact();

        return token;
    }

    private SecretKey getSigninKey() {
         byte[] encodedKey = Base64.getDecoder().decode(SECRET_KEY);
         return Keys.hmacShaKeyFor(encodedKey);
    }

    private Claims extractAllClaims (String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigninKey()) // Use correct signing key method
                .build()
                .parseClaimsJws(token) // Parses the signed JWT
                .getBody();
    }

    public <T> T extractClaims(String token, Function<Claims,T> resolver ) {
         Claims claims = extractAllClaims(token);
         return resolver.apply(claims);
    }

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public boolean validateToken(String token, UserDetails userAccount) {
        String username = extractUsername(token);
        return userAccount.getUsername().equals(username) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return  extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

}
