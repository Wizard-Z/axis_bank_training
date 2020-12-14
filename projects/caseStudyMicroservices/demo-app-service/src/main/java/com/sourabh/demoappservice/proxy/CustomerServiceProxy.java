package com.sourabh.demoappservice.proxy;


import com.sourabh.demoappservice.model.Customer;
import com.sourabh.demoappservice.model.CustomerSend;
import org.bson.Document;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="booking-service")
@RibbonClient(name="booking-service")
public interface CustomerServiceProxy {
    @GetMapping("/customers/all")
    public List<Customer> getAll();

    @GetMapping("/customers/bookings-datewise")
    public Document getDatewiseBookings();

    @GetMapping("/customers/earning-datewise")
    public Document getDatewiseEarning();

    @GetMapping("/customers/occupants")
    public Document getOccupantsCounts();
    @PostMapping("/customers/booking-add")
    public Customer addCustomer(@RequestBody CustomerSend customer);

}
