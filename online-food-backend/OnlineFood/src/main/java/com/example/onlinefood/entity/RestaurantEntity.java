package com.example.onlinefood.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String cuisineType;

    private String openingHours;

    private LocalDateTime registrationDate;

    private boolean isOpen;

    @OneToOne
    private UserEntity owner;

    @OneToOne
    private AddressEntity address;

    @Embedded
    private ContactInfoEntity contactInfo;

    @OneToMany(
        mappedBy = "restaurant",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderEntity> orders = new ArrayList<>();

    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    @JsonIgnoreProperties(value = "restaurant")
    @OneToMany(
        mappedBy = "restaurant",
        cascade = CascadeType.ALL
    )
    private List<FoodEntity> foods = new ArrayList<>();
}
