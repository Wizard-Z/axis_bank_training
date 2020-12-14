package com.sourabh.hotelreservation.controller

import com.sourabh.hotelreservation.model.Transaction
import com.sourabh.hotelreservation.service.TransactionService
import io.swagger.annotations.ApiOperation
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TransactionController(@Autowired val transactionService: TransactionService) {
    @GetMapping("/transactions/all")
    @ApiOperation(value = "Show complete transaction table", notes = "Returns complete transaction table.")
    fun getAll():MutableList<Transaction>{
        return transactionService.getAll()
    }

    @GetMapping("/transactions/{id}")
    @ApiOperation(value = "Get a specific Transaction detail.", notes = "Provide an id to get specific transaction detail.")
    fun getById(@PathVariable id: Int):Transaction{
        return transactionService.getById(id)
    }

    @GetMapping("/transactions/earnings")
    @ApiOperation(value = "Shows money earned by different categories of room.", notes = "Provides a summarization of transactions")
    fun getRoomWiseEarnings(): Document? {
        return transactionService.getRoomWiseEarnings()
    }




}