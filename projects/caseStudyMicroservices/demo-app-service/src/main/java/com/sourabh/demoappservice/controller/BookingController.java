package com.sourabh.demoappservice.controller;


import com.sourabh.demoappservice.model.Room;
import com.sourabh.demoappservice.proxy.HotelServiceProxy;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookingController {

   /*
    @Autowired
    CustomerService customerService;*/
    @Autowired
    private HotelServiceProxy hotelServiceProxy;

    @GetMapping("/echo")
    @ApiOperation(value = "echo test",
    notes = "Check if server is up and running.")
    public String echo(){
        return "Hello All!!!";
    }

    //Will be used
    @GetMapping("/bookings/rooms")
    @ApiOperation(value = "Get All Rooms",
            notes = "Shows which rooms are available for booking along with all details.")
    public List<Room> getAll(){

        List<Room> rooms = hotelServiceProxy.getAllRooms();
        rooms.sort((o1,o2) -> Float.compare(o1.getPrice(),o2.getPrice()));
        return rooms;
    }

    //Will be used
    @GetMapping("/bookings/available-rooms/")
    @ApiOperation(value = "Get Available Rooms",
            notes = "Shows which rooms are available for booking along with all details.")
    public List<Room> getAllAvailable(){

        List<Room> rooms = hotelServiceProxy.getAllAvailable();
        rooms.sort((o1,o2) -> Float.compare(o1.getPrice(),o2.getPrice()));
        return rooms;
    }
    //Will be used
    @GetMapping("/bookings/room-by-id/{id}")
    @ApiOperation(value = "Get rooms by Id", notes = "Provide an Id to get the room details if available")
    public Room findByIdAvailable(@PathVariable int id){
        return hotelServiceProxy.findById(id);
    }

    //Will be used

    @PostMapping("/rooms-toggle/{id}")
    @ApiOperation(value = "Flag a room so that it cannot be booked.",
            notes = "Provide an id. based on which if available the room will be not allowed\n" +
                    "to be booked.")
    public Room deleteRoom(@PathVariable int id){
        return hotelServiceProxy.removeRoom(id);
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

    @PostMapping("/update-room-count/{id}/{value}")
    public Room updateRoomCount(@PathVariable int id,@PathVariable int value){
        return hotelServiceProxy.updateRoomCount(id,value);
    }

    @PostMapping("/add-rooms")
    public Room addRoom(@RequestBody Room room ){
        return hotelServiceProxy.addRoom(room);
    }



}
