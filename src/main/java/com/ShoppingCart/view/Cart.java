package com.ShoppingCart.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "itemname", nullable = false)
    @JsonProperty
    private String itemName;

    @Column(name = "price", nullable = false)
    @JsonProperty
    private float price;

    public Cart() {
    }

    public Cart(long id,String itemName, float price) {
        this.id = id;
        this.itemName = itemName;
        this.price=price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
