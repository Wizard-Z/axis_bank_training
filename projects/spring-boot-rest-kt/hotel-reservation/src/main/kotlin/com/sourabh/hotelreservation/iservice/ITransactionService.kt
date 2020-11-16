package com.sourabh.hotelreservation.iservice

import com.sourabh.hotelreservation.model.Transaction

interface ITransactionService {
    fun getAll():MutableList<Transaction>
    fun getById(id:Int):Transaction
    fun addOrUpdate(transaction: Transaction):Transaction
}