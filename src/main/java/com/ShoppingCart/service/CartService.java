package com.ShoppingCart.service;

import com.ShoppingCart.repositories.CartRepository;
import com.ShoppingCart.repositories.ItemRepository;
import com.ShoppingCart.view.Cart;
import com.ShoppingCart.view.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {

    ItemRepository itemRepository;
    CartRepository cartRepository;


    @Autowired
    public CartService(ItemRepository itemRepository, CartRepository cartRepository) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }


    public static void addItem(Item item) {

    }

    public Cart addToCart(Cart cartItem) {
        cartRepository.save(cartItem);
        return cartItem;
    }
}
