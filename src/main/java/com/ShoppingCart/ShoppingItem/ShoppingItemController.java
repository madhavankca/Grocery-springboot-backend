package com.ShoppingCart.ShoppingItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingItemController {
    @Autowired
    ShoppingItemService shoppingItemService;

    public ShoppingItemController(ShoppingItemService shoppingItemService) {
        this.shoppingItemService = shoppingItemService;
    }

    @PostMapping("/storeTheItems")
    public String storeShoppingItem(@RequestBody ShoppingItem requestItem){
        shoppingItemService.addToCart(requestItem);
        return "success";
    }
}
