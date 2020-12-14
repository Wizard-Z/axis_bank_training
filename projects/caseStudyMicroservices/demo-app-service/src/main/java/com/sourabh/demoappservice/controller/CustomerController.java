package com.sourabh.demoappservice.controller;


import com.sourabh.demoappservice.exceptions.SomethingNotFoundException;
import com.sourabh.demoappservice.kafkas.ProduceK;
import com.sourabh.demoappservice.model.Customer;
import com.sourabh.demoappservice.model.CustomerSend;
import com.sourabh.demoappservice.model.Room;
import com.sourabh.demoappservice.model.Transaction;
import com.sourabh.demoappservice.proxy.CustomerServiceProxy;
import com.sourabh.demoappservice.proxy.HotelServiceProxy;
import com.sourabh.demoappservice.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerServiceProxy customerServiceProxy;
    @Autowired
    private HotelServiceProxy hotelServiceProxy;
    @Autowired
    TransactionService transactionService;
    @Autowired
    Transaction transaction;
    @Autowired
    ProduceK produceK;


//    @ApiOperation(value = "Fetches complete customers information.", notes = "Gives the complete list of customers who has ever book a room.")
//    @GetMapping("/all")
//    public List<Customer> getAll(){
//        return customerServiceProxy.getAll();
//    } will not work as I added random data to customer collections


    @ApiOperation(value = "Shows datewise and typewise grouped result",
            notes = "Gives a aggregate of Rooms booked and date on which they were booked.\n" +
                    "Summarizes the result.")
    @GetMapping("/bookings-datewise")
    public Document getDatewiseBookings(){
        return customerServiceProxy.getDatewiseBookings();
    }

    @GetMapping("/earning-datewise")
    public  Document getDatewiseEarning(){
        return customerServiceProxy.getDatewiseEarning();
    }

    @GetMapping("/occupants")
    public Document getOccupantsCounts(){
        return customerServiceProxy.getOccupantsCounts();
    }

    @PostMapping("/bookings/customers")
    @ApiOperation(value = "Add customer to the table",
            notes = "Provide the customer details. If valid then based on input its fare will be calculated and necessary" +
                    " changes will be updated in the database.\n " +
                    "Provide: 'cid','name','type','days','fullpay'")
    public Customer addCustomer(@RequestBody Customer customer){
        Room room = hotelServiceProxy.findById(customer.getRid());
        if (room.isAvailable()){
            CustomerSend customerSend = new CustomerSend(room,customer);
            Customer cust=customerServiceProxy.addCustomer(customerSend);
            hotelServiceProxy.updateRoomCount((int) room.getId(),-1);
            /*Making transaction*/
            transaction.setId(cust.getCid());
            transaction.setCustomer(cust);
            if(cust.isFullPay())
                transaction.setAmount(cust.getTotalFair());
            else
                transaction.setAmount(room.getPrice());
            transactionService.addOrUpdate(transaction);
            //Send to confluent cloud!
            produceK.produce(transaction);

            return cust;

        }

        throw new SomethingNotFoundException("ERROR: Room is no longer available");


    }






}
//TODO: Booking logic update.