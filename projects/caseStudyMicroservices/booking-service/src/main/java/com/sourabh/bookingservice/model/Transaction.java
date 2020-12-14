package com.sourabh.bookingservice.model;

import io.swagger.annotations.ApiModel;


@ApiModel(description = "Details about the transactions.")
public class Transaction {
    private int id;
    private Customer customer;
    private float amount;

    public Transaction(){}

    public Transaction(int id, Customer customer, float amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
