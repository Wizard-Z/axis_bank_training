package com.sourabh.demo.controller;

import com.sourabh.demo.model.Customer;
import com.sourabh.demo.model.Room;
import com.sourabh.demo.service.CustomerService;
import com.sourabh.demo.service.RoomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRoomController {

    @Autowired
    RoomService roomService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/echo")
    @ApiOperation(value = "echo test",
    notes = "Check if server is up and running.")
    public String echo(){
        return "Hello All!!!";
    }

    @GetMapping("/hotels/bookings/rooms")
    @ApiOperation(value = "Get Available Rooms",
            notes = "Shows which rooms are available for booking along with all details.")
    public List<Room> getAll(){
        return roomService.getAllAvailable();
    }


    @GetMapping("/hotels/bookings/rooms/{id}")
    @ApiOperation(value = "Get rooms by Id",
            notes = "Provide an Id to get the room details if available")
    public Room findByIdAvailable(@PathVariable int id){
        return roomService.findByIdAvailable(id);
    }

    @GetMapping("/hotels/bookings/rooms-type/{type}")
    @ApiOperation(value = "Returns room of a particular type",
            notes = "Provide the 'type' of room for which details is to be searched.")
    public Room findBytype(@PathVariable String type){
        return roomService.findByTypeAvailable(type);
    }

    @PostMapping("/hotels/bookings/get-customers")
    @ApiOperation(value = "Add customer to the table",
            notes = "Provide the customer details. If valid then based on input its fare will be calculated and necessary" +
                    " changes will be updated in the database.\n " +
                    "Provide: 'cid','name','type','days','fullpay'")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);

    }

}
