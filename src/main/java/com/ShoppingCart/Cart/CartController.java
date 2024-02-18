package com.ShoppingCart.Cart;

import com.ShoppingCart.Item.Item;
import com.ShoppingCart.Item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private CartService cartService;

 //   Cart cart = new Cart();

@GetMapping("/getAllItems")
public ResponseEntity<List<Item>> getAllItems(){
    List<Item> itemList = itemService.getAllItems();
    return ResponseEntity.ok(itemList);
}

//@PostMapping("/addToCart")
//public ResponseEntity<Cart> addToCart(@RequestBody Map<String, Long> request) {
//    Long itemId = request.get("itemId");
//
//    if (itemId == null)
//        return ResponseEntity.badRequest().build();
//    Item savedItem = itemService.getItemById(itemId);
//    CartItem cartItem = new CartItem();
//    cartItem.setItem(savedItem);
//    cartItem.setCart(new Cart());
//
//    Cart savedCartItem = cartItemService.addToCart(cartItem);
//
//    return ResponseEntity.ok(savedCartItem);
//}

}
