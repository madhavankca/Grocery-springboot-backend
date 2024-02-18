package com.ShoppingCart.Cart;

import com.ShoppingCart.CartItem.CartItem;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CART")
public class Cart {

        @Id
        @JsonIgnore
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        public Cart() {
        }


        public Cart(long id, List<CartItem> cartItem) {
            this.id = id;
        }


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cart cart = (Cart) o;
            return id == cart.id;
        }
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

