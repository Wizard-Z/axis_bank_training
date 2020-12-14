package com.sourabh.bookingservice.model;

import io.swagger.annotations.ApiModel;



@ApiModel(description = "Details about the Customer.")
public  class CustomerSend {
        public Room room;
        public Customer customer;

        public CustomerSend(){}
        public CustomerSend(Room room, Customer customer) {
            this.room = room;
            this.customer = customer;
        }

        public Room getRoom() {
            return room;
        }

        public void setRoom(Room room) {
            this.room = room;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
    }