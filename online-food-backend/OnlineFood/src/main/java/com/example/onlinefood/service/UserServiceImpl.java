package com.example.onlinefood.service;

import com.example.onlinefood.entity.UserEntity;
import com.example.onlinefood.exception.InvalidOperationException;
import com.example.onlinefood.exception.UserNotFoundException;
import com.example.onlinefood.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserEntity saveUser(UserEntity entity) {
        //Find user in db
        val user = userRepository.findByEmail(entity.getEmail());
        if(user != null) {
            throw new InvalidOperationException("Email is already used with another account");
        }

        //Save user
        UserEntity newUser = new UserEntity();
        newUser.setEmail(entity.getEmail());
        newUser.setFullName(entity.getFullName());
        newUser.setRole(entity.getRole());
        newUser.setPassword(passwordEncoder.encode(entity.getPassword()));

        return userRepository.save(newUser);
    }

    @Override
    public UserEntity findUserByEmail(UserEntity entity) {
        //Find user in db
        val user = userRepository.findByEmail(entity.getEmail());

        if(user == null){
            throw new UserNotFoundException("User not found with email.");
        }

        return user;
    }
}
