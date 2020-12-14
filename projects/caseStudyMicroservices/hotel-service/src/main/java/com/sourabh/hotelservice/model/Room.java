package com.sourabh.hotelservice.model;


import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="rooms")
@ApiModel(description = "Details about the rooms available in hotel.")
public class Room {
    @Id
    private long id;
    private String name;
    private String type;
    private float price;
    private int left;
    private boolean available;
    private int capacity;
    private boolean featured;
    public Room(){}

    public Room(long id, String type, float price, int left, boolean available) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.left = left;
        this.available = available;
    }

    public Room(long id, String name, String type, float price, int left, boolean available, int capacity, boolean featured) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.left = left;
        this.available = available;
        this.capacity = capacity;
        this.featured = featured;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
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
