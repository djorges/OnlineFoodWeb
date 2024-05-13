package com.example.onlinefood.controller;

import com.example.onlinefood.config.JwtProvider;
import com.example.onlinefood.entity.CartEntity;
import com.example.onlinefood.entity.UserEntity;
import com.example.onlinefood.entity.UserRole;
import com.example.onlinefood.model.AuthResponse;
import com.example.onlinefood.model.LoginRequest;
import com.example.onlinefood.service.CartService;
import com.example.onlinefood.service.CustomerUserDetailsService;
import com.example.onlinefood.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomerUserDetailsService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(
        @RequestBody UserEntity entity
    ){
        //Save User
        val savedUser = userService.saveUser(entity);

        //Save Cart
        val newCart = new CartEntity();
        newCart.setCustomer(savedUser);

        cartService.saveCart(newCart);

        //
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            savedUser.getEmail(),
            savedUser.getPassword()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Register successfully");
        authResponse.setRole(savedUser.getRole());
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(
            @RequestBody LoginRequest loginRequest
    ){
        String userName = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        UserDetails userDetails = service.loadUserByUsername(userName);

        if(userDetails == null){
            throw new BadCredentialsException("Invalid username...");
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Invalid username...");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
               userDetails,
               null,
                userDetails.getAuthorities()
        );
        val authorities = authentication.getAuthorities();
        String role = authorities.isEmpty() ? null : authorities.iterator().next().getAuthority();
        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Logged in successfully");
        authResponse.setRole(UserRole.valueOf(role));
        return ResponseEntity.ok(authResponse);
    }

}
