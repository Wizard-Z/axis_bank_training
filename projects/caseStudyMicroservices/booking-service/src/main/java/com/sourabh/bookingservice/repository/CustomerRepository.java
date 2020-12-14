package com.sourabh.bookingservice.repository;


import com.sourabh.bookingservice.model.Customer;
import com.sourabh.bookingservice.model.TypeOccupant;
import org.bson.Document;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

    @Aggregation(pipeline = {"{$match:{status:true}}","{$group:{_id:'$type', count:{$sum:1}}}"})
    AggregationResults<TypeOccupant> getOccupantCounts();


    @Aggregation(pipeline = {"{$group:{_id:'$type', count:{$sum:1}}}"})
    AggregationResults<TypeOccupant> getOccupantCountsHistory();

    @Aggregation(pipeline={"{$group:{_id:{type:\"$type\",month:{$month:\"$bookDate\"},year:{$year:\"$bookDate\"}}, count:{$sum:1}}}"})
    AggregationResults<Document> getDateWiseBooking();

    @Aggregation(pipeline={"{$group:{_id:{type:\"$type\",month:{$month:\"$bookDate\"},year:{$year:\"$bookDate\"}}, sum:{$sum:\"$totalFair\"}}}"})
    AggregationResults<Document> getDateWiseEarning();

}
