package com.example.onlinefood.controller;

import com.example.onlinefood.dto.RestaurantDto;
import com.example.onlinefood.entity.RestaurantEntity;
import com.example.onlinefood.service.RestaurantService;
import com.example.onlinefood.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<RestaurantEntity>> searchRestaurants(
        @RequestHeader("Authorization") String token,
        @RequestParam String keyword
    ){
        userService.findUserByJwtToken(token);

        val restaurant = restaurantService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantEntity>> getAllRestaurants(
        @RequestHeader("Authorization") String token
    ){
        userService.findUserByJwtToken(token);

        val restaurant = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantEntity> findRestaurantById(
        @RequestHeader("Authorization") String token,
        @PathVariable Long id
    ){
        userService.findUserByJwtToken(token);

        val restaurant = restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addRestaurantToFavorites(
        @RequestHeader("Authorization") String token,
        @PathVariable Long id
    ){
        val user = userService.findUserByJwtToken(token);

        val restaurant = restaurantService.addRestaurantToFavorites(id, user);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
