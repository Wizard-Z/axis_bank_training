package com.sourabh.demo.iservice;

import com.sourabh.demo.model.Customer;
import org.bson.Document;

import java.util.List;

public interface ICustomerService {
    public Customer addCustomer(Customer customer);
    public List<Customer> getAll();
    public Document getOccupantsCounts();
    public Document getOccupantsCountsHistory();
    public Document getDateWiseBooking();
    public Customer getCustomer(int id);
    public float calculateFare(int days, float baseFare);
}
