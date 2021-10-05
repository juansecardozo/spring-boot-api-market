package com.example.market.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    private static final String KEY = "example_key";

    public String generateToken(final UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public boolean validateToken(final String token, final UserDetails userDetails) {
        return userDetails.getUsername().equals(extractUser(token)) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(final String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    public String extractUser(final String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(final String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
