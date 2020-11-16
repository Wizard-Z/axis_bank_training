package com.sourabh.demo.iservice;

import com.sourabh.demo.model.Transaction;
import org.bson.Document;

import java.util.List;

public interface ITransactionService {
    public List<Transaction> getAll();
    public Transaction getById(int id);
    public Transaction addOrUpdate(Transaction transaction);
    public Document getRoomWiseEarnings();
}
