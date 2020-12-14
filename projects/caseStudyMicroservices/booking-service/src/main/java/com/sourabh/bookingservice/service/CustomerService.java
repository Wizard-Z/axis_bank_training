package com.sourabh.bookingservice.service;


import com.sourabh.bookingservice.exceptions.SomethingNotFoundException;
import com.sourabh.bookingservice.model.Customer;
import com.sourabh.bookingservice.model.Room;
import com.sourabh.bookingservice.repository.CustomerRepository;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
//    @Autowired
//    RoomService roomService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SequenceGeneratorService sequenceGenerator;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Customer addCustomer(Customer customer, Room room) {
        if(customer.getDays()<=0)
            throw new SomethingNotFoundException("Invalid number of days");
        Room roomdetails = room;
        float baseFare = roomdetails.getPrice();
        customer.setCid(sequenceGenerator.generateSequence(Customer.SEQUENCE_NAME)+100);
        customer.setTotalFair(calculateFare(customer.getDays(), baseFare));
        customer.setStatus(true);
        customer.setBookDate(LocalDateTime.now());
        logger.info("details: {}",customer);
//
//        roomService.updateRoomCount(roomdetails,-1);
//        transaction.setId(customer.getCid());
//        transaction.setCustomer(customer);
//        if(customer.isFullPay())
//            transaction.setAmount(customer.getTotalFair());
//        else
//            transaction.setAmount(baseFare);
//        transactionService.addOrUpdate(transaction);
        return customerRepository.save(customer);

    }


    public List<Customer> getAll(){

        List<Customer> customers=customerRepository.findAll();
        if(customers.isEmpty())
            throw new SomethingNotFoundException("No Customer data yet!!");
        return customers;
    }
    public Document getOccupantsCounts(){
        return customerRepository.getOccupantCounts().getRawResults();
    }
    public Document getOccupantsCountsHistory(){
        return customerRepository.getOccupantCountsHistory().getRawResults();
    }

    public Document getDateWiseBooking(){
        return customerRepository.getDateWiseBooking().getRawResults();
    }


    public Customer getCustomer(int id){
        return customerRepository.findById(id).orElseThrow(() -> new SomethingNotFoundException("No Customer for the given id: " + id));
    }

    public float calculateFare(int days, float baseFare){
        if(days>=5)
            return (days-1)*baseFare;
        return days*baseFare;
    }
    public Document getDateWiseEarning(){

        return customerRepository.getDateWiseEarning().getRawResults();
    }




}

