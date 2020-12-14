package com.sourabh.demoappservice.controller;

import com.sourabh.demoappservice.model.Transaction;
import com.sourabh.demoappservice.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions/all")
    @ApiOperation(value = "Show complete transaction table", notes = "Returns complete transaction table.")
    public List<Transaction> getAll(){
        return transactionService.getAll();
    }

    @GetMapping("/transactions/{id}")
    @ApiOperation(value = "Get a specific Transaction detail.", notes = "Provide an id to get specific transaction detail.")
    public Transaction getById(@PathVariable int id){
        return transactionService.getById(id);
    }

    @GetMapping("/transactions/earnings")
    @ApiOperation(value = "Shows money earned by different categories of room.",notes = "Provides a summarization of transactions")
    public Document getRoomWiseEarnings(){
        return transactionService.getRoomWiseEarnings();
    }
}
