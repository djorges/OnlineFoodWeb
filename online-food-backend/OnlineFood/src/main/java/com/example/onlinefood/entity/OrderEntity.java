package com.example.onlinefood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long totalAmount;

    private String orderStatus;

    private Date createdAt;

    private int totalItem;

    private int totalPrice;

    @ManyToOne
    private UserEntity user;

    @JsonIgnore
    @ManyToOne
    private RestaurantEntity restaurant;

    @ManyToOne
    private AddressEntity deliveryAddress;

    @OneToMany
    private List<OrderItemEntity> items;
}
