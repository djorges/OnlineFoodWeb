package com.example.onlinefood.service;

import com.example.onlinefood.dto.RestaurantDto;
import com.example.onlinefood.entity.RestaurantEntity;
import com.example.onlinefood.entity.UserEntity;
import com.example.onlinefood.model.RestaurantRequest;

import java.util.List;

public interface RestaurantService {
    RestaurantEntity createRestaurant(RestaurantRequest req, UserEntity user);
    RestaurantEntity updateRestaurant(Long restaurantId, RestaurantRequest req);
    void deleteRestaurant(Long restaurantId);
    List<RestaurantEntity> getAllRestaurants();
    List<RestaurantEntity> searchRestaurant(String keyword);
    RestaurantEntity findRestaurantById(Long restaurantId);
    RestaurantEntity getRestaurantByUserId(Long userId);
    RestaurantDto addRestaurantToFavorites(Long restaurantId, UserEntity user);
    RestaurantEntity updateRestaurantStatus(Long restaurantId);
}
