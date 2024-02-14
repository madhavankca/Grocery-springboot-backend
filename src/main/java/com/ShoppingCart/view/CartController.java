package com.ShoppingCart.view;

import com.ShoppingCart.service.CartService;
import com.ShoppingCart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CartController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private CartService cartService;

@PostMapping("/addToCart")
public ResponseEntity<Cart> addToCart(@RequestBody Map<String, Long> request) {
    Long itemId = request.get("itemId");

    if (itemId == null)
        return ResponseEntity.badRequest().build();
    Item savedItem = itemService.getItemById(itemId);
    Cart cartItem = new Cart();
    cartItem.setItemName(savedItem.getItemName());
    cartItem.setId(savedItem.getId());
    cartItem.setPrice(savedItem.getPrice());

    Cart savedCartItem = cartService.addToCart(cartItem);

    return ResponseEntity.ok(savedCartItem);
}



}
