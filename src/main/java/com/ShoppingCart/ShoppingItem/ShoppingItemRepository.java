package com.ShoppingCart.ShoppingItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem,Long> {
    Optional<ShoppingItem> findByName(String name);
}
