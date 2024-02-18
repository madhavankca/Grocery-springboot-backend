package com.ShoppingCart.CartItem;

import com.ShoppingCart.Cart.Cart;
import com.ShoppingCart.Item.Item;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CARTITEM")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "QUANTITY")
    private long quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CARTID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "ITEMID")
    private Item item;

    public CartItem() {
    }

    public CartItem(long id, long quantity, Item item,Cart cart) {
        this.id = id;
        this.quantity = quantity;
        this.item = item;
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return id == cartItem.id && quantity == cartItem.quantity && Objects.equals(item, cartItem.item) && Objects.equals(cart, cartItem.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, item, cart);
    }
}
