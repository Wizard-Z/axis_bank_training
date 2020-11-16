package com.sourabh.demo.servicetest;

import com.sourabh.demo.exceptions.SomethingNotFoundException;
import com.sourabh.demo.model.Customer;
import com.sourabh.demo.model.Room;
import com.sourabh.demo.model.Transaction;
import com.sourabh.demo.repository.CustomerRepository;
import com.sourabh.demo.service.CustomerService;
import com.sourabh.demo.service.RoomService;
import com.sourabh.demo.service.SequenceGeneratorService;
import com.sourabh.demo.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @MockBean
    RoomService roomService;
    @MockBean
    CustomerRepository customerRepository;
    @MockBean
    TransactionService transactionService;
    @MockBean
    SequenceGeneratorService sequenceGenerator;
    @MockBean
    Transaction transaction;

    @Test
    void addCustomerTest(){
        Customer customer = new Customer();
        customer.setName("Sourabh");
        customer.setType("Suit");
        customer.setDays(5);
        customer.setPaymentMethod("UPI");
        customer.setFullPay(true);
        Room room = new Room(1,"Suit",1200,12,true);
        when(roomService.findByTypeAvailable("Suit")).thenReturn(room);
        when(sequenceGenerator.generateSequence(Customer.SEQUENCE_NAME)).thenReturn(1);
        Customer modifiedCustomer = new Customer();
        modifiedCustomer.setName("Sourabh");
        modifiedCustomer.setType("Suit");
        modifiedCustomer.setDays(5);
        modifiedCustomer.setPaymentMethod("UPI");
        modifiedCustomer.setFullPay(true);
        modifiedCustomer.setCid(101);
        modifiedCustomer.setTotalFair(4800);
        modifiedCustomer.setStatus(true);
        modifiedCustomer.setBookDate(LocalDateTime.now());
        when(customerRepository.save(customer)).thenReturn(modifiedCustomer);
        Assertions.assertEquals(modifiedCustomer,customerService.addCustomer(customer));
    }

    @Test
    void addCustomerTest2(){
        Customer customer = new Customer();
        customer.setName("Sourabh");
        customer.setType("Suit");
        customer.setDays(0);
        customer.setPaymentMethod("UPI");
        customer.setFullPay(true);
        Assertions.assertThrows(SomethingNotFoundException.class, ()->customerService.addCustomer(customer));
    }

    @Test
    void getAllTest(){

        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer(1,"OtherMe","Suit",6,6000,true,"UPI", LocalDateTime.now(),true);
        Customer customer2 = new Customer(2,"SourabhOther","Suit",6,6000,true,"UPI", LocalDateTime.now(),true);
        Customer customer3 = new Customer(3,"HelloMe","Suit",6,6000,true,"UPI", LocalDateTime.now(),true);
        Customer customer4 = new Customer(4,"Sourabh4","Single-Room",6,6000,true,"UPI", LocalDateTime.now(),true);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        when(customerRepository.findAll()).thenReturn(customers);
        Assertions.assertEquals(4,customerService.getAll().size());
    }
    @Test
    void getCustomerTest(){
        Customer customer = new Customer(1,"Sourabh","Suit",6,6000,true,"UPI", LocalDateTime.now(),true);
        when(customerRepository.findById(1)).thenReturn(java.util.Optional.of(customer));
        Assertions.assertEquals(customer.getName(),customerService.getCustomer(1).getName());

    }

    @Test
    void calculateFareTest(){
        int days = 5;
        float baseFare = 1200.0F;
        float expected = 4800.0F;
        Assertions.assertEquals(expected,customerService.calculateFare(days,baseFare));

    }







}
