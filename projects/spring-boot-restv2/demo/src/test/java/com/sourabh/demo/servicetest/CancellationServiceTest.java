package com.sourabh.demo.servicetest;


import com.sourabh.demo.model.Customer;
import com.sourabh.demo.model.Room;
import com.sourabh.demo.model.Transaction;
import com.sourabh.demo.repository.CustomerRepository;
import com.sourabh.demo.service.CancellationService;
import com.sourabh.demo.service.RoomService;
import com.sourabh.demo.service.TransactionService;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@SpringBootTest
class CancellationServiceTest {
    @InjectMocks
    CancellationService cancellationService;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    RoomService roomService;
    @Mock
    TransactionService transactionService;



    @Test
    void getCustomerTest(){
        Customer customer = new Customer(1,"Sourabh","Suit",6,6000,true,"UPI", LocalDateTime.now(),true);
        when(customerRepository.findById(1)).thenReturn(java.util.Optional.of(customer));
        Assertions.assertEquals(customer, cancellationService.getCustomer(1));
    }
    @Test
    void cancelRoomTest(){
        Customer customer = new Customer(1,"Sourabh","Suit",6,6000,true,"UPI", LocalDateTime.now(),true);
        when(customerRepository.findById(1)).thenReturn(java.util.Optional.of(customer));

        Room room = new Room(1,"Suit",1200,12,true);
        when(roomService.findByType("Suit")).thenReturn(room);

        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setCustomer(customer);
        transaction.setAmount(6000);
        when(transactionService.getById(1)).thenReturn(transaction);

        String actual=cancellationService.cancelRoom(1);
        JSONObject obj = new JSONObject(actual);
        Assertions.assertEquals(4800,obj.get("Refund"));

    }

    @Test
    void cancelRoomTest2(){
        Customer customer = new Customer(1,"Sourabh","Suit",6,6000,false,"UPI", LocalDateTime.now(),true);
        when(customerRepository.findById(1)).thenReturn(java.util.Optional.of(customer));

        Room room = new Room(1,"Suit",1200,12,true);
        when(roomService.findByType("Suit")).thenReturn(room);

        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setCustomer(customer);
        transaction.setAmount(6000);
        when(transactionService.getById(1)).thenReturn(transaction);

        String actual=cancellationService.cancelRoom(1);
        JSONObject obj = new JSONObject(actual);
        Assertions.assertEquals(0,obj.get("Refund"));

    }



}
