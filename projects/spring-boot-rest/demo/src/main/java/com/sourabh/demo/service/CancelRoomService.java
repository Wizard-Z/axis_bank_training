package com.sourabh.demo.service;

import com.sourabh.demo.exceptions.SomethingNotFoundException;
import com.sourabh.demo.model.Customer;
import com.sourabh.demo.model.Room;
import com.sourabh.demo.model.Transaction;
import com.sourabh.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelRoomService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RoomService roomService;

    @Autowired
    TransactionService transactionService;

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new SomethingNotFoundException("No Customer for the given id: " + id));
    }

    public String cancelRoom(int id) {
        Customer customer = getCustomer(id);

        if (!customer.isStatus())
            throw new SomethingNotFoundException("Customer id not valid. Invalid id: " + id);
        Room room = roomService.findByType(customer.getType());
        float basefare = room.getPrice();
        float refund = 0;
        boolean fullPay = customer.isFullPay();
        if(fullPay)
            refund = customer.getTotalFair()-basefare;
        customer.setStatus(false);
        Transaction transaction = transactionService.getById(customer.getCid());
        transaction.setCustomer(customer);
        transaction.setAmount(basefare);
        transactionService.addOrUpdate(transaction);
        customerRepository.save(customer);
        roomService.updateRoomCount(room,1);

        return "Full Payment: "+fullPay+" Basefare: "+basefare+"\nRefund: "+refund;


    }

}

