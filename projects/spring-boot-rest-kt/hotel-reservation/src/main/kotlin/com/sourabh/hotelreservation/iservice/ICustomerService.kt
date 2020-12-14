package com.sourabh.hotelreservation.iservice

import com.sourabh.hotelreservation.model.Customer
import com.sourabh.hotelreservation.repository.TypeOccupant
import org.bson.Document
import org.springframework.data.mongodb.core.aggregation.AggregationResults

interface ICustomerService {

    fun addCustomer(customer:Customer):Customer
    fun getAll():MutableList<Customer>
    fun getOccupantsCounts(): Document
    fun getOccupantsCountHistory(): Document
    fun getCustomer(id:Int):Customer
    fun calculateFare(days:Int, baseFare:Float):Float
    fun getDateWiseBookings():Document
}