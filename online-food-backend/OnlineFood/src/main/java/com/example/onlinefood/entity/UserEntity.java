package com.example.onlinefood.entity;

import com.example.onlinefood.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String email;

    private String password;

    private UserRoles role;

    //
    @JsonIgnoreProperties("user")//or @JsonIgnore
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        mappedBy = "user"
    )
    private List<OrderEntity> orders = new ArrayList<>();

    @JsonIgnoreProperties("user")//or @JsonIgnore
    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        mappedBy = "user"
    )
    private List<AddressEntity> addresses = new ArrayList<>();

    @ElementCollection
    private List<RestaurantDto> restaurants = new ArrayList<>();
}
