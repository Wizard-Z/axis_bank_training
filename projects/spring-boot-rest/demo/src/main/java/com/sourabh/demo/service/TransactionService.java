package com.sourabh.demo.service;

import com.sourabh.demo.exceptions.SomethingNotFoundException;
import com.sourabh.demo.model.Transaction;
import com.sourabh.demo.repository.TransactionRepository;
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
        return transactionRepository.findById(id).orElseThrow(() -> new SomethingNotFoundException("No Customer for the given id: " + id));
    }

    public Transaction addOrUpdate(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
