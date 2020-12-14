package com.sourabh.hotelreservation.controller

import com.sourabh.hotelreservation.exception.SomethingNotFoundException
import com.sourabh.hotelreservation.model.Customer
import com.sourabh.hotelreservation.model.Room
import com.sourabh.hotelreservation.service.CustomerService
import com.sourabh.hotelreservation.service.RoomService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")

class BookingController {
    @Autowired
    var roomService: RoomService? = null

    @Autowired
    var customerService: CustomerService? = null
    @GetMapping("/echo")
    @ApiOperation(value = "echo test", notes = "Check if server is up and running.")
    fun echo(): String {
        return "Hello All!!!"
    }

    @GetMapping("/bookings/rooms")
    @ApiOperation(value = "Get Available Rooms", notes = "Shows which rooms are available for booking along with all details.")
    fun getAll(): MutableList<Room>? {
        return roomService?.getAllAvailable()
    }

    @GetMapping("/bookings/rooms/{id}")
    @ApiOperation(value = "Get rooms by Id", notes = "Provide an Id to get the room details if available")
    fun findByIdAvailable(@PathVariable id: Int): Room {
        return roomService!!.findByIdAvailable(id)
    }

    @GetMapping("/bookings/rooms-type/{type}")
    @ApiOperation(value = "Returns room of a particular type", notes = "Provide the 'type' of room for which details is to be searched.")
    fun findBytype(@PathVariable type: String): Room {
        return roomService!!.findByTypeAvailable(type)
    }

    @GetMapping("/bookings/rooms/price")
    @ApiOperation(value = "Get rooms filtered by Price", notes = "Provide an range, based on which rooms which falls in that price bracket would be displayed.")
    fun findByPriceRange(@RequestParam("startPrice") startP: Int,
                         @RequestParam(value = "endPrice", required = false) endP: Int?): List<Room>? {
        val rooms: List<Room>? = getAll()
        val filteredRooms: MutableList<Room> = ArrayList()
        if (endP != null) {
            for (room in rooms!!) {
                if (room.price >= startP && room.price <= endP) filteredRooms.add(room)
            }
        } else {
            for (room in rooms!!) {
                if (room.price >= startP) filteredRooms.add(room)
            }
        }
        filteredRooms.sortWith(java.util.Comparator { o1: Room, o2: Room -> o1.price.compareTo(o2.price) })
        if(filteredRooms.size==0)
            throw SomethingNotFoundException("No Room available in this price range!")
        return filteredRooms
    }


    @PostMapping("/bookings/customers")
    @ApiOperation(value = "Add customer to the table", notes = "Provide the customer details. If valid then based on input its fare will be calculated and necessary changes will be updated in the database.Provide: 'cid','name','type','days','fullpay'")
    fun addCustomer(@RequestBody customer: Customer): Customer {
        return customerService!!.addCustomer(customer)
    }
}

