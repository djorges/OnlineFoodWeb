package com.example.onlinefood.model;

import com.example.onlinefood.entity.AddressEntity;
import com.example.onlinefood.entity.ContactInfoEntity;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantRequest {
    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private AddressEntity address;
    private ContactInfoEntity contactInfoEntity;
    private String openingHours;
    private List<String> images;
}
