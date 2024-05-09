package com.example.onlinefood.service;

import com.example.onlinefood.entity.UserEntity;

public interface UserService {
    UserEntity saveUser(UserEntity entity);
    UserEntity findUserByEmail(UserEntity entity);
}
