package com.sourabh.demo.iservice;

import com.sourabh.demo.model.Customer;

public interface ICancelRoomService {
    public Customer getCustomer(int id);
    public String cancelRoom(int id);
}
