package com.sourabh.demo.repository;

import com.sourabh.demo.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction,Integer> {
}
