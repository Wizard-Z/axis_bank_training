package com.sourabh.hotelreservation.service

import com.sourabh.hotelreservation.exception.SomethingNotFoundException
import com.sourabh.hotelreservation.iservice.ITransactionService
import com.sourabh.hotelreservation.model.Transaction
import com.sourabh.hotelreservation.repository.TransactionRepository
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService(@Autowired var transactionRepository: TransactionRepository):ITransactionService {
    override fun getAll(): MutableList<Transaction> {
        val transactions = transactionRepository.findAll()
        if(transactions.isEmpty())
            throw SomethingNotFoundException("No transactions yet!!")
        return transactions
    }

    override fun getById(id: Int): Transaction {
        return transactionRepository.findById(id).orElseThrow { SomethingNotFoundException("No Transaction found for the id: $id") }
    }

    override fun addOrUpdate(transaction: Transaction): Transaction {
        return transactionRepository.save(transaction)

    }
    fun getRoomWiseEarnings(): Document? {
        return transactionRepository.getRoomWiseEarnings()!!.rawResults
    }
}