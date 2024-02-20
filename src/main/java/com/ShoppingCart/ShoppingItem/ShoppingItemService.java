package com.ShoppingCart.ShoppingItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemService {
    private final ShoppingItemRepository shoppingItemRepository;

    @Autowired
    public ShoppingItemService(ShoppingItemRepository shoppingItemRepository) {
        this.shoppingItemRepository = shoppingItemRepository;
    }

    public void addToCart(ShoppingItem shoppingItem) {
        shoppingItemRepository.save(shoppingItem);
    }

    public List<ShoppingItem> getCartList() {
        return this.shoppingItemRepository.findAll();
    }
}
