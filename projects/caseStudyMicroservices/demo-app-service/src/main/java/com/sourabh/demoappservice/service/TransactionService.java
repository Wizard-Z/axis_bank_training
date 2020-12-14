package com.sourabh.demoappservice.service;

import com.sourabh.demoappservice.exceptions.SomethingNotFoundException;
import com.sourabh.demoappservice.model.Transaction;
import com.sourabh.demoappservice.repository.TransactionRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;



    public List<Transaction> getAll(){
        List<Transaction> transactions = transactionRepository.findAll();
        if(transactions.isEmpty())
            throw new SomethingNotFoundException("No Transactions yet!!");
        return transactions;
    }

    public Transaction getById(int id) {
        return transactionRepository.findById(id).orElseThrow(() -> new SomethingNotFoundException("No Transaction for the given id: " + id));
    }

    public Transaction addOrUpdate(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public Document getRoomWiseEarnings(){
        return transactionRepository.getRoomWiseEarnings().getRawResults();
    }
}
