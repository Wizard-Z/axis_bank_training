package com.sourabh.hotelreservation.repository

import com.sourabh.hotelreservation.model.Customer
import org.bson.Document
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.repository.Aggregation
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository:MongoRepository<Customer, Int> {

    @Aggregation(pipeline = ["{\$match:{status:true}}", "{\$group:{_id:'\$type', count:{\$sum:1}}}"])
    fun getOccupantCounts(): AggregationResults<TypeOccupant?>?

    @Aggregation(pipeline = ["{\$group:{_id:'\$type', count:{\$sum:1}}}"])
    fun getOccupantCountsHistory(): AggregationResults<TypeOccupant?>?

    @Aggregation(pipeline = ["{\$group:{_id:{type:\"\$type\",day:{\$dayOfMonth:\"\$bookDate\"},month:{\$month:\"\$bookDate\"},year:{\$year:\"\$bookDate\"}}, count:{\$sum:1}}}"])
    fun getDateWiseBooking(): AggregationResults<Document?>?

}