package com.ShoppingCart.Item;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @JsonProperty("id")
//    @ApiModelProperty(name = "id", value = "Id of the Item (must be unique)", required = true, example = "user_name", position = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    @JsonProperty("name")
//    @ApiModelProperty(name = "name", value = "Name of item (must be unique)", required = true, example = "user_name")
    private String name;

    @Column(name = "PRICE")
    @JsonProperty("price")
//    @ApiModelProperty(name = "price", value = "Price of item (must be unique)", required = true, example = "user_name")
    private float price;

    public Item() {

    }

    public Item(long id, String itemName, float price) {
        this.id = id;
        this.name = itemName;
        this.price = price;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Float.compare(price, item.price) == 0 && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
