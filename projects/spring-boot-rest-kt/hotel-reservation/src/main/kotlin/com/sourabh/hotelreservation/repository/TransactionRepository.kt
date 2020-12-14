package com.sourabh.hotelreservation.repository

import com.sourabh.hotelreservation.model.Transaction
import org.bson.Document
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.repository.Aggregation
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository :MongoRepository<Transaction, Int> {
    @Aggregation(pipeline = ["{\$group:{_id:'\$customer.type',sum:{\$sum:'\$amount' }}}", "{\$sort:{sum:-1}}"])
    fun getRoomWiseEarnings(): AggregationResults<Document?>?
}