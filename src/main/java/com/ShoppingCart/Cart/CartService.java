package com.ShoppingCart.Cart;

import com.ShoppingCart.Item.ItemRepository;
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


    public static void createCart() {

    }

    public void createNewCart(Cart cart1) {

    }

//    public CartController.Cart addToCart(CartController.Cart cartItem) {
//        cartRepository.save(cartItem);
//        return cartItem;
//    }
}
