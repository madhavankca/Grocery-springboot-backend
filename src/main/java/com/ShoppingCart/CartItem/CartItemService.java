package com.ShoppingCart.CartItem;

import com.ShoppingCart.Item.Item;
import com.ShoppingCart.Item.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemService {
    CartItemRepository cartItemRepository;
    ItemRepository itemRepository;

    public CartItemService(CartItemRepository cartItemRepository, ItemRepository itemRepository) {
        this.cartItemRepository = cartItemRepository;
        this.itemRepository = itemRepository;
    }

    public Optional<CartItem> findByColumnName(Long itemId) {
        return cartItemRepository.findByitem(itemId);
    }

    public void updateQuantity(CartItem cartItem,int updater) {
        long updatedQuantity = cartItem.getQuantity()+updater;
        cartItem.setQuantity(updatedQuantity < 0 ? 0 : updatedQuantity);
        cartItemRepository.save(cartItem);
    }

    public void createNewCartItem(Optional<Item> item) {
        System.out.println("So create new item");
        CartItem newCartItem = new CartItem();
        newCartItem.setQuantity(1);
        newCartItem.setItem(null);

        cartItemRepository.save(newCartItem);
    }

    public void addNewItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

//    @PostMapping("addCartItem/{id}")
//    public boolean isItemPresent(@PathVariable Long id) {
//        CartItem cartItem = cartItemRepository.findById(id).get();
//        if(cartItem == null){
//
//        }
//        else{
//            CartItem newCartItem = new CartItem();
//            Item item = itemRepository.getById(id);
//            newCartItem.setItem(item);
//            newCartItem.setQuantity(cartItem.getQuantity()+1);
//
//        }
//
//
//    }



}
