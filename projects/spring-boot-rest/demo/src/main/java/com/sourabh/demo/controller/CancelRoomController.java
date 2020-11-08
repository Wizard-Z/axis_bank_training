package com.sourabh.demo.controller;

import com.sourabh.demo.model.Customer;
import com.sourabh.demo.service.CancelRoomService;
import com.sourabh.demo.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CancelRoomController {
    @Autowired
    CancelRoomService cancelRoomService;
    @ApiOperation(value = "Enter customer-id to cancel booking.",
            notes = "Provide c.id and based on it booking will be cancelled\n" +
                    "Refund will be calculated.")
    @GetMapping("/hotels/cancellations/{id}")
    public String cancelRoom(@PathVariable int id){
        return cancelRoomService.cancelRoom(id);



    }


}
