package com.ShoppingCart.service;
import com.ShoppingCart.repositories.ItemRepository;
import com.ShoppingCart.view.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    public Item getItemById(long id) {
        Optional<Item> optionalItem = this.itemRepository.findById(id);
        return optionalItem.orElse(null);
    }
}
