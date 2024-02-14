package com.ShoppingCart.view;

import com.ShoppingCart.service.CartService;
import com.ShoppingCart.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ShoppingCartController {
    @Autowired
    ItemService itemService;
    @Autowired
    CartService cartService;
    @GetMapping("/getAllItems")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> itemList = itemService.getAllItems();
        return ResponseEntity.ok(itemList);
    }

}
