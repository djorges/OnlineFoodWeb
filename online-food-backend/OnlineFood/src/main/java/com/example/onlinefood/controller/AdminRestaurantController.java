package com.example.onlinefood.controller;

import com.example.onlinefood.entity.RestaurantEntity;
import com.example.onlinefood.model.RestaurantRequest;
import com.example.onlinefood.service.RestaurantService;
import com.example.onlinefood.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<RestaurantEntity> createRestaurant(
        @RequestBody RestaurantRequest restaurantRequest,
        @RequestHeader("Authorization") String token
    ){
          val user = userService.findUserByJwtToken(token);

          val restaurant = restaurantService.createRestaurant(restaurantRequest, user);
          return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantEntity> updateRestaurant(
        @RequestBody RestaurantRequest restaurantRequest,
        @RequestHeader("Authorization") String token,
        @PathVariable Long id
    )  {
        userService.findUserByJwtToken(token);

        val restaurant = restaurantService.updateRestaurant(id, restaurantRequest);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(
        @RequestHeader("Authorization") String token,
        @PathVariable Long id
    ){
        userService.findUserByJwtToken(token);

        restaurantService.deleteRestaurant(id);

        return new ResponseEntity<>("Restaurant deleted",HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<RestaurantEntity> updateRestaurantStatus(
        @RequestHeader("Authorization") String token,
        @PathVariable Long id
    ){
        userService.findUserByJwtToken(token);

        val restaurant = restaurantService.updateRestaurantStatus(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<RestaurantEntity> findRestaurantByUserId(
        @RequestBody RestaurantRequest request,
        @RequestHeader("Authorization") String token
    ){
        userService.findUserByJwtToken(token);

        val restaurant = restaurantService.getRestaurantByUserId(request.getId());

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
