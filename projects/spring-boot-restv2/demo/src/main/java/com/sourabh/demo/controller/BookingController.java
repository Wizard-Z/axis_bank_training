package com.sourabh.demo.controller;

import com.sourabh.demo.model.Customer;
import com.sourabh.demo.model.Room;
import com.sourabh.demo.service.CustomerService;
import com.sourabh.demo.service.RoomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {

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

    @GetMapping("/bookings/rooms")
    @ApiOperation(value = "Get Available Rooms",
            notes = "Shows which rooms are available for booking along with all details.")
    public List<Room> getAll(){
        return roomService.getAllAvailable();
    }


    @GetMapping("/bookings/rooms/{id}")
    @ApiOperation(value = "Get rooms by Id", notes = "Provide an Id to get the room details if available")
    public Room findByIdAvailable(@PathVariable int id){
        return roomService.findByIdAvailable(id);
    }

    @GetMapping("/bookings/rooms/price")
    @ApiOperation(value = "Get rooms filtered by Price",notes = "Provide an range, based on which rooms which falls in that price bracket would be displayed.")
    public List<Room> findByPriceRange(@RequestParam("startPrice") Integer startP,
                                       @RequestParam(value="endPrice",required = false) Integer endP){
        List<Room> rooms = getAll();
        List<Room> filteredRooms = new ArrayList<>();
        if(endP!=null) {
            for (Room room : rooms) {
                if (room.getPrice() >= startP && room.getPrice() <= endP)
                    filteredRooms.add(room);

            }
        }
        else{
            for (Room room : rooms) {
                if (room.getPrice() >= startP)
                    filteredRooms.add(room);
            }

        }
        filteredRooms.sort((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));

        return  filteredRooms;
    }

    @GetMapping("/bookings/rooms-type/{type}")
    @ApiOperation(value = "Returns room of a particular type",
            notes = "Provide the 'type' of room for which details is to be searched.")
    public Room findBytype(@PathVariable String type){
        return roomService.findByTypeAvailable(type);
    }

    @PostMapping("/bookings/customers")
    @ApiOperation(value = "Add customer to the table",
            notes = "Provide the customer details. If valid then based on input its fare will be calculated and necessary" +
                    " changes will be updated in the database.\n " +
                    "Provide: 'cid','name','type','days','fullpay'")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);

    }

}
