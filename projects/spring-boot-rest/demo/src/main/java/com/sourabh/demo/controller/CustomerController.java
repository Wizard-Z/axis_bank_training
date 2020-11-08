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
    @ApiOperation(value = "Fetches complete customers information.",
            notes = "Gives the complete list of customers who has ever book a room.")
    @GetMapping("hotels/customers/all")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @ApiOperation(value = "Shows current occupants count",
            notes = "Shows the summarized details of which all rooms are booked.\n" +
                    "Their current counts.")
    @GetMapping("hotels/customers/occupants")
    public Document getOccupantsCounts(){
        return customerService.getOccupantsCounts();
    }

    @ApiOperation(value = "Shows occupants count",
            notes = "Shows the historical view of which rooms are booked how many times till now.")
    @GetMapping("hotels/customers/occupants/history")
    public Document getOccupantsCountsHistory(){
        return customerService.getOccupantsCountsHistory();
    }

    @ApiOperation(value = "Shows datewise and typewise grouped result",
            notes = "Gives a aggregate of Rooms booked and date on which they were booked.\n" +
                    "Summarizes the result.")
    @GetMapping("hotels/customers/bookings-datewise")
    public  Document getDatewiseBookings(){
        return customerService.getDateWiseBooking();
    }
}
