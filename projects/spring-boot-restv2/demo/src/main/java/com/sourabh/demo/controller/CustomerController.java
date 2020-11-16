package com.sourabh.demo.controller;

import com.sourabh.demo.model.Customer;
import com.sourabh.demo.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "Fetches complete customers information.", notes = "Gives the complete list of customers who has ever book a room.")
    @GetMapping("/customers/all")
    public List<Customer> getAll(){
        return customerService.getAll();
    }


    @ApiOperation(value = "Shows datewise and typewise grouped result",
            notes = "Gives a aggregate of Rooms booked and date on which they were booked.\n" +
                    "Summarizes the result.")
    @GetMapping("/customers/bookings-datewise")
    public  Document getDatewiseBookings(){
        return customerService.getDateWiseBooking();
    }
}
