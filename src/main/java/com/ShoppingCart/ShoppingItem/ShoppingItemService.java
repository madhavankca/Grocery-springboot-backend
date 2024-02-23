package com.ShoppingCart.ShoppingItem;
import com.ShoppingCart.Item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public boolean updateQuantity(Item requestedItem) {
        Optional<ShoppingItem> optionalShoppingItem = shoppingItemRepository.findByName(requestedItem.getName());

        if (optionalShoppingItem.isPresent()) {

            ShoppingItem shoppingItem = optionalShoppingItem.get();
            shoppingItem.setQuantity(shoppingItem.getQuantity() + 1);
            shoppingItem.setTotalPrice(shoppingItem.getTotalPrice() + shoppingItem.getPricePerQuantity());
            shoppingItemRepository.save(shoppingItem);

            return true;
        } else {
            ShoppingItem shoppingItem = new ShoppingItem();

            shoppingItem.setId(requestedItem.getId());
            shoppingItem.setQuantity(1);
            shoppingItem.setName(requestedItem.getName());
            shoppingItem.setPricePerQuantity((long) requestedItem.getPrice());
            shoppingItem.setTotalPrice((long) requestedItem.getPrice());
            shoppingItemRepository.save(shoppingItem);

            return true;
        }
    }

    public void emptyCart() {
        shoppingItemRepository.deleteAll();
    }
}
