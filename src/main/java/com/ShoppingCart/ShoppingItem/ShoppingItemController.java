package com.ShoppingCart.ShoppingItem;

import com.ShoppingCart.Item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingItemController {
    @Autowired
    ShoppingItemService shoppingItemService;

    public ShoppingItemController(ShoppingItemService shoppingItemService) {
        this.shoppingItemService = shoppingItemService;
    }

    @DeleteMapping("/deleteAllItems")
    public ResponseEntity<String> deleteAllItems(){
        shoppingItemService.emptyCart();
        return ResponseEntity.ok("Fresh Cart");
    }
    @GetMapping("/getCartItems")
    public ResponseEntity<List<ShoppingItem>> getCartItems(){
        List<ShoppingItem> cartList = shoppingItemService.getCartList();
        return ResponseEntity.ok(cartList);
    }

    @PostMapping("/storeTheItems")
    public ResponseEntity<String> storeShoppingItem(@RequestBody Item requestItem){
        if(shoppingItemService.updateQuantity(requestItem))
            return ResponseEntity.ok("Successfully updated the quantity");
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Could not update the cart item");
    }
}
