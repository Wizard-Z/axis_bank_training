package com.sourabh.hotelservice.controller;


import com.sourabh.hotelservice.model.Room;
import com.sourabh.hotelservice.service.RoomService;
import io.swagger.annotations.ApiOperation;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    RoomService roomService;

    /*@Autowired
    CustomerService customerService;*/

    //Will be used
    @PostMapping("/rooms")
    @ApiOperation(value = "Add room to the repository",
            notes = "Provide a Room details and it will be updated in repository!")
    public Room addOrUpdateRoom(@RequestBody Room room){
        return roomService.addOrUpdate(room);
    }


    //Will be used
    @GetMapping("/rooms")
    @ApiOperation(value = "Get all Rooms",
            notes = "Displays all the rooms available in Hotel.")
    public List<Room> getAll(){
        return roomService.getAll();
    }

    //Will be used
    @GetMapping("/rooms/available")
    public List<Room> getAllAvailable(){
        return roomService.getAllAvailable();
    }
    //Will be used
    @GetMapping("/rooms/id/{id}")
    @ApiOperation(value = "Provide id to get room details")
    public Room findById(@PathVariable int id){
        return roomService.findById(id);
    }
    //Will be used
    @PostMapping("/rooms/{id}")
    @ApiOperation(value = "Flag a room so that it cannot be booked.",
            notes = "Provide an id. based on which if available the room will be not allowed\n" +
                    "to be booked.")
    public Room deleteRoom(@PathVariable int id){
        return roomService.removeRoom(id);
    }

    @PostMapping("/rooms/update-count/{id}/{value}")
    public Room room(@PathVariable int id,@PathVariable int value){
        return roomService.updateRoomCount(id,value);
    }



    @PostMapping("/add-bulk/rooms")
    @ApiOperation(value = "Add all Rooms",
            notes = "Provide a list of rooms to be added to repository.")
    public List<Room> addAll(@RequestBody List<Room> rooms){
        return roomService.addAll(rooms);
    }

    @GetMapping("/rooms-type/{type}")
    @ApiOperation(value = "Returns room of a particular type",
            notes = "Provide the 'type' of room for which details is to be searched.")
    public Room findBytype(@PathVariable String type) {
        return roomService.findByTypeAvailable(type);
    }

   /* @ApiOperation(value = "Shows current occupants count", notes = "Shows the summarized details of which all rooms are booked.\nTheir current counts.")
    @GetMapping("/rooms/occupants")
    public Document getOccupantsCounts(){
        return customerService.getOccupantsCounts();
    }*/

   /* @ApiOperation(value = "All rooms booked till now",
            notes = "Shows the historical view of which rooms are booked how many times till now.")
    @GetMapping("/rooms/history")
    public Document getOccupantsCountsHistory(){
        return customerService.getOccupantsCountsHistory();
    }*/

}
