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
    private int qty;
    private boolean status;
    public Room(){}

    public Room(long id, String type, float price, int qty, boolean status) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.qty = qty;
        this.status = status;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
