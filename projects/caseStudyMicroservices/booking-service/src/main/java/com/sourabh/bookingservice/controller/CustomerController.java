package com.sourabh.bookingservice.controller;

import com.sourabh.bookingservice.model.Customer;
import com.sourabh.bookingservice.model.CustomerSend;
import com.sourabh.bookingservice.model.Room;
import com.sourabh.bookingservice.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

   @Autowired
   CustomerService customerService;

    @ApiOperation(value = "Fetches complete customers information.", notes = "Gives the complete list of customers who has ever book a room.")
    @GetMapping("/all")
    public List<Customer> getAll(){
       List<Customer> cc = customerService.getAll();
        System.out.println(":::::::"+cc);
        return cc;
    }


    @ApiOperation(value = "Shows datewise and typewise grouped result",
            notes = "Gives a aggregate of Rooms booked and date on which they were booked.\n" +
                    "Summarizes the result.")
    @GetMapping("/bookings-datewise")
    public  Document getDatewiseBookings(){
        return customerService.getDateWiseBooking();
    }

    @GetMapping("/earning-datewise")
    public  Document getDatewiseEarning(){
        return customerService.getDateWiseEarning();
    }

    @GetMapping("/occupants")
    public Document getOccupantsCounts(){
        return customerService.getOccupantsCounts();
    }

    @PostMapping("/booking-add")
    @ApiOperation(value = "Add customer to the table",
            notes = "Provide the customer details. If valid then based on input its fare will be calculated and necessary" +
                    " changes will be updated in the database.\n " +
                    "Provide: 'cid','name','type','days','fullpay'")
    public Customer addCustomer(@RequestBody CustomerSend customerSend){

        return customerService.addCustomer(customerSend.getCustomer(),customerSend.getRoom());
    }

}
