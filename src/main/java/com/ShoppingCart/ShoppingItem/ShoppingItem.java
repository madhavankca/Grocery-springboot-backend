package com.ShoppingCart.ShoppingItem;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "SHOPPINGITEM")
public class ShoppingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICEPERQUANTITY")
    private long pricePerQuantity;

    @Column(name = "QUANTITY")
    private long quantity;

    @Column(name = "TOTALPRICE")
    private long totalPrice;

    public ShoppingItem() {
    }

    public ShoppingItem(long id, String name, long pricePerQuantity, long quantity, long totalPrice) {
        this.id = id;
        this.name = name;
        this.pricePerQuantity = pricePerQuantity;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPricePerQuantity() {
        return pricePerQuantity;
    }

    public void setPricePerQuantity(long pricePerQuantity) {
        this.pricePerQuantity = pricePerQuantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingItem that = (ShoppingItem) o;
        return id == that.id && pricePerQuantity == that.pricePerQuantity && quantity == that.quantity && totalPrice == that.totalPrice && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pricePerQuantity, quantity, totalPrice);
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerQuantity=" + pricePerQuantity +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
