package com.ShoppingCart.CartItem;

import com.ShoppingCart.Item.Item;
import com.ShoppingCart.Item.ItemService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CartItemController {
    @Autowired
    CartItemService cartItemService;
    @Autowired
    ItemService itemService;

    public CartItemController(CartItemService cartItemService, ItemService itemService) {
        this.cartItemService = cartItemService;
        this.itemService = itemService;
    }
    //    @PostMapping ("addThisItem/{itemId}")
//    public boolean addCartItem (@RequestBody Long itemId){
//        boolean CartItemAdded = cartItemService.isItemPresent(itemId);
//        return true;
//    }

    @PostMapping("/addToCart/increment")
    public boolean addToCart(@RequestBody Item requestItem) {
        System.out.println("CartItemController In1");
        System.out.println(requestItem);
        Long itemId = requestItem.getId();
        System.out.println(itemId);

        Optional<Item> item = itemService.getItemById(itemId);
        System.out.println("Is item present in Item table "+ item.isPresent());
        if(item.isPresent()){
            System.out.println("CartItemController In3");
            Optional<CartItem> optionalCartItem = cartItemService.findByColumnName(itemId);
            System.out.println("CartItemController In4");
            if(optionalCartItem.isPresent()){
                CartItem cartItem = optionalCartItem.get();
                cartItemService.updateQuantity(cartItem,1);
                System.out.println("CartItemController In5");
            }
            else{
                System.out.println("item not already present");
                cartItemService.createNewCartItem(item);
            }
        }
        System.out.println("Controller out");
        return true;
    }



    @PostMapping("/addToCart/decrement")
    public boolean removeToCart(@RequestBody Item requestItem) {
        System.out.println("CartItemController In1");
        System.out.println(requestItem);
        Long itemId = requestItem.getId();
        System.out.println(itemId);

        Optional<Item> item = itemService.getItemById(itemId);
//        if(item != null){
        System.out.println("Is item present in Item table "+ item.isPresent());
        if(item.isPresent()){
            System.out.println("CartItemController In3");
            Optional<CartItem> optionalCartItem = cartItemService.findByColumnName(itemId);
            System.out.println("CartItemController In4");
            if(optionalCartItem.isPresent()){
                CartItem cartItem = optionalCartItem.get();
                cartItemService.updateQuantity(cartItem,-1);
                System.out.println("CartItemController In5");
            }
            else{
                System.out.println("item not already present");
                cartItemService.createNewCartItem(item);
            }
        }
        System.out.println("Controller out");
        return true;
    }

}
