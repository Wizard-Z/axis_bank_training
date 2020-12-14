package com.sourabh.demo.model;

import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="rooms")
@ApiModel(description = "Details about the rooms available in hotel.")
public class Room {
    @Id
    private long id;
    private String type;
    private float price;
    private int left;
    private boolean available;
    public Room(){}

    public Room(long id, String type, float price, int left, boolean available) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.left = left;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
