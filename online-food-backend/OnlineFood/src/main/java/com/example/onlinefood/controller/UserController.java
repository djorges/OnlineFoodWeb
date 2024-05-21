package com.example.onlinefood.controller;


import com.example.onlinefood.entity.UserEntity;
import com.example.onlinefood.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserEntity> findUserByJwtToken(
            @RequestHeader("Authorization") String token
    ) throws Exception {
      val user = userService.findUserByJwtToken(token);
      return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

