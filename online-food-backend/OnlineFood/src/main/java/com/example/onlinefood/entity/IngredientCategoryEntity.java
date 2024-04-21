package com.example.onlinefood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredient_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    private RestaurantEntity restaurant;

     @OneToMany(
         mappedBy = "category",
         cascade = CascadeType.ALL
     )
     private List<IngredientEntity> ingredients = new ArrayList<>();
}
