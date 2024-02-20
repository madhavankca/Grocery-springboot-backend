package com.ShoppingCart.ShoppingItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/getCartItems")
    public ResponseEntity<List<ShoppingItem>> getCartItems(){
        List<ShoppingItem> cartList = shoppingItemService.getCartList();
        return ResponseEntity.ok(cartList);
    }
}
