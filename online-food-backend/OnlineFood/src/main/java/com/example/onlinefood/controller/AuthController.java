package com.example.onlinefood.controller;

import com.example.onlinefood.config.JwtProvider;
import com.example.onlinefood.entity.CartEntity;
import com.example.onlinefood.entity.UserEntity;
import com.example.onlinefood.model.AuthResponse;
import com.example.onlinefood.repository.CartRepository;
import com.example.onlinefood.service.CartService;
import com.example.onlinefood.service.CustomerUserDetailsService;
import com.example.onlinefood.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomerUserDetailsService service;


    public ResponseEntity<AuthResponse> createUserHandler(
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
        return ResponseEntity.ok(authResponse);
    }
}
