package com.example.onlinefood.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@PropertySource("classpath:jwt.properties")
public class JwtTokenValidator extends OncePerRequestFilter {
    @Value("${jwt.header}")
    private String JWT_HEADER;

    @Value("${jwt.secretKey}")
    private String JWT_SECRET_KEY;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        var jwt = request.getHeader(JWT_HEADER);

        if(jwt != null){
            jwt = jwt.substring(7); //Omit prefix

            try{
                //Get claims
                val claims = Jwts.parserBuilder()
                        .setSigningKey(Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes()))
                        .build()
                        .parseClaimsJws(jwt)
                        .getBody();
                val email = String.valueOf(claims.get("email"));
                val authorities = String.valueOf(claims.get("authorities"));

                val authList = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
                val auth = new UsernamePasswordAuthenticationToken(email,null,authList);
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (Exception e){
                throw new BadCredentialsException("invalid token...");
            }
        }
        filterChain.doFilter(request,response);
    }
}

