package com.example.onlinefood.service;

import com.example.onlinefood.dto.RestaurantDto;
import com.example.onlinefood.entity.RestaurantEntity;
import com.example.onlinefood.entity.UserEntity;
import com.example.onlinefood.exception.EntityNotFoundException;
import com.example.onlinefood.model.RestaurantRequest;
import com.example.onlinefood.repository.AddressRepository;
import com.example.onlinefood.repository.RestaurantRepository;
import com.example.onlinefood.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public RestaurantEntity createRestaurant(RestaurantRequest req, UserEntity user) {
        val address = addressRepository.save(req.getAddress());
        val restaurant = new RestaurantEntity();

        restaurant.setAddress(address);
        restaurant.setName(req.getName());
        restaurant.setDescription(req.getDescription());
        restaurant.setName(req.getName());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setContactInfo(req.getContactInfoEntity());
        restaurant.setImages(req.getImages());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public RestaurantEntity updateRestaurant(Long restaurantId, RestaurantRequest req) {
        val restaurant = findRestaurantById(restaurantId);

        if(restaurant.getCuisineType() != null){
            restaurant.setCuisineType(req.getCuisineType());
        }

        if(restaurant.getDescription() != null){
            restaurant.setDescription(req.getDescription());
        }

        if(restaurant.getName() != null){
            restaurant.setName(req.getName());
        }

        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        val restaurant = findRestaurantById(restaurantId);

        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<RestaurantEntity> searchRestaurant(String keyword) {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public RestaurantEntity findRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(()->
            new EntityNotFoundException("Restaurant with id " + restaurantId + " not found")
        );
    }

    @Override
    public RestaurantEntity getRestaurantByUserId(Long userId) {
        val restaurant = restaurantRepository.findByOwnerId(userId);

        if(restaurant == null){
            throw new EntityNotFoundException("Restaurant with owner id " + userId + " not found");
        }

        return restaurant;
    }

    @Override
    public RestaurantDto addRestaurantToFavorites(Long restaurantId, UserEntity user) {

        val restaurant = findRestaurantById(restaurantId);

        val restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurantId);
        restaurantDto.setDescription(restaurant.getDescription());
        restaurantDto.setImages(restaurant.getImages());
        restaurantDto.setTitle(restaurant.getName());

        val favorites = user.getRestaurants();
        if(favorites.contains(restaurantDto)){
            favorites.remove(restaurantDto);
        }else{
            favorites.add(restaurantDto);
        }

        userRepository.save(user);
        return restaurantDto;
    }

    @Override
    public RestaurantEntity updateRestaurantStatus(Long restaurantId) {
        val restaurant = findRestaurantById(restaurantId);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRepository.save(restaurant);
    }
}
