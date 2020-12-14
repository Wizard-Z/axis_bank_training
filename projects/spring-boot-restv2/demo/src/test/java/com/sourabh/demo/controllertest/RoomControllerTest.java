package com.sourabh.demo.controllertest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sourabh.demo.controller.BookingController;
import com.sourabh.demo.model.Customer;
import com.sourabh.demo.service.CustomerService;
import com.sourabh.demo.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(BookingController.class)
class RoomControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RoomService roomService;
    @MockBean
    private CustomerService customerService;

    @Test
    void echoTest() throws Exception {
        mvc.perform(get("/api/echo").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello All!!!"));
    }

    @Test
    void getAllTest() throws Exception {
        mvc.perform(get("/api/bookings/rooms")
        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void addCustomerTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setDays(5);
        customer.setName("Sourabh");
        customer.setType("Suit");
        customer.setPaymentMethod("UPI");
        customer.setFullPay(true);
        mvc.perform(post("/api/bookings/customers")
                .content(objectMapper.writeValueAsString(customer))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().json(objectMapper.writeValueAsString(customer)));
    }






}
