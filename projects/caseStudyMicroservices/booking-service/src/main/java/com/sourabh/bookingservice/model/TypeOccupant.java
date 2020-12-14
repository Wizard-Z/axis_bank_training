package com.sourabh.bookingservice.model;

public class TypeOccupant {
    private String type;
    private int count;
    public TypeOccupant(){}

    public TypeOccupant(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
