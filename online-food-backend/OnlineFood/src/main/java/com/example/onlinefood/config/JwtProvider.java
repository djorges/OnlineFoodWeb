package com.example.onlinefood.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@PropertySource("classpath:jwt.properties")
public class JwtProvider {

    @Value("${jwt.secretKey}")
    private String JWT_SECRET_KEY;

    @Value("${jwt.expiration_time_in_millis}")
    private long JWT_EXPIRATION_TIME_IN_MILLIS;

    public String generateToken(Authentication auth){

        val authorities = auth.getAuthorities();
        String roles = String.join(",", authorities.stream().map(GrantedAuthority::getAuthority).toList());

        //Create token
        String jwt = Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_TIME_IN_MILLIS))
                .claim("email", auth.getName())
                .claim("authorities", roles)
                .signWith(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()))
                .compact();

        return jwt;
    }

    public String getEmailFromJwtToken(String jwt){
        jwt = jwt.substring(7);

        //Get claims
        val claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()))
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        return String.valueOf(claims.get("email"));
    }
}
