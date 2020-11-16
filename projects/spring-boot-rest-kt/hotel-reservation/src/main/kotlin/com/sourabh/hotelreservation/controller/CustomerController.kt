package com.sourabh.hotelreservation.controller



import com.sourabh.hotelreservation.model.Customer
import com.sourabh.hotelreservation.repository.TypeOccupant
import com.sourabh.hotelreservation.service.CustomerService
import io.swagger.annotations.ApiOperation
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class CustomerController(@Autowired val customerService: CustomerService) {
    @GetMapping("/customers/all")
    @ApiOperation(value = "Fetches complete customers information.", notes = "Gives the complete list of customers who has ever book a room.")
    fun getAll():MutableList<Customer>{
        return customerService.getAll()
    }

    @GetMapping("/customers/occupants")
    @ApiOperation(value = "Shows current occupants count", notes = """Shows the summarized details of which all rooms are booked.
Their current counts.""")
    fun getOccupantsCounts(): Document {
        return customerService.getOccupantsCounts()
    }

    @GetMapping("/customers/occupants/history")
    @ApiOperation(value = "Shows occupants count", notes = "Shows the historical view of which rooms are booked how many times till now.")
    fun getOccupantsCountsHistory(): Document {
        return customerService.getOccupantsCountHistory()
    }

    @GetMapping("/customers/bookings-datewise")
    @ApiOperation(value = "Shows datewise and typewise grouped result", notes = "Gives a aggregate of Rooms booked and date on which they were booked.Summarizes the result.")
    fun getDateWiseBookings():Document{
        return customerService.getDateWiseBookings()
    }


}
