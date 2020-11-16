package com.sourabh.hotelreservation.controller

import com.sourabh.hotelreservation.model.Room
import com.sourabh.hotelreservation.service.RoomService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class RoomController(@Autowired private val roomService: RoomService) {

    @PostMapping("/rooms")
    @ApiOperation(value = "Add room to the repository", notes = "Provide a Room details and it will be updated in repository!")
    fun addOrUpdateRoom(@RequestBody room: Room):Room{
        return roomService.addOrUpdate(room)
    }

    @GetMapping("/rooms")
    @ApiOperation(value = "Get All Rooms", notes = "Display all rooms available in Hotel.")
    fun getAll():MutableList<Room>?{
        return roomService.getAll()
    }

    @PostMapping("/add-bulk/rooms")
    @ApiOperation(value = "Add all Rooms", notes = "Provide a list of rooms to be added to repository.")
    fun addAll(@RequestBody rooms: MutableList<Room>):MutableList<Room>{
        return roomService.addAll(rooms)
    }

    @DeleteMapping("/rooms{id}")
    @ApiOperation(value = "Flag a room so that it cannot be booked.", notes = """Provide an id. based on which if available the room will be not allowed
to be booked.""")
    fun deleteRoom(@PathVariable id: Int):Room{
        return roomService.removeRoom(id)
    }

}