package com.example.onlinefood.model;

import com.example.onlinefood.entity.UserRole;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private UserRole role;
}
