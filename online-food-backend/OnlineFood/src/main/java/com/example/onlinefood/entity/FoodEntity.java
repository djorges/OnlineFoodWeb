package com.example.onlinefood.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "foods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private boolean available;

    private boolean isVegetarian;

    private boolean isSeasonal;

    private Date creationDate;

    @ManyToOne
    private CategoryEntity category;

    @ManyToOne
    private RestaurantEntity restaurant;

    @Column(length = 1000)
    @ElementCollection
    private List<String> images;

    @ManyToMany
    private List<IngredientEntity> ingredients = new ArrayList<>();
}
