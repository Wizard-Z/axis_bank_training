package com.sourabh.demo.repository;

import com.sourabh.demo.model.Transaction;
import org.bson.Document;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction,Integer> {
    @Aggregation(pipeline = {"{$group:{_id:'$customer.type',sum:{$sum:'$amount' }}}","{$sort:{sum:-1}}"})
    AggregationResults<Document> getRoomWiseEarnings();
}
