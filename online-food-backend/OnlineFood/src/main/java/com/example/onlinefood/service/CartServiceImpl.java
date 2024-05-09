package com.example.onlinefood.service;

import com.example.onlinefood.entity.CartEntity;
import com.example.onlinefood.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartEntity saveCart(CartEntity entity) {
        return cartRepository.save(entity);
    }
}
