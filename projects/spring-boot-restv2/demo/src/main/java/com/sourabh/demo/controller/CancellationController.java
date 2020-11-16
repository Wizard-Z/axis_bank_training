package com.sourabh.demo.controller;

import com.sourabh.demo.service.CancellationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CancellationController {
    @Autowired
    CancellationService cancellationService;
    //CancelRoomContro

    @ApiOperation(value = "Enter customer-id to cancel booking.",
            notes = "Provide c.id and based on it booking will be cancelled\n" +
                    "Refund will be calculated.")
    @DeleteMapping("/cancellations/{id}")
    public String cancelRoom(@PathVariable int id){
        return cancellationService.cancelRoom(id);



    }


}
