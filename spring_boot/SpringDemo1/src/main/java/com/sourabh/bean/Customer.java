package com.sourabh.bean;

public class Customer {
    private int cid;
    private String name;
    private Address address;
    private Contact contact;


    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", contact=" + contact +
                '}';
    }

    public Customer(int cid, String name, Address address, Contact contact) {
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public Customer(){}

    public Customer(int cid, String name, Address address) {
        this.cid = cid;
        this.name = name;
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
