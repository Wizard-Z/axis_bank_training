package com.sourabh.hotelreservation.service

import com.sourabh.hotelreservation.exception.SomethingNotFoundException
import com.sourabh.hotelreservation.iservice.ICancelRoomService
import com.sourabh.hotelreservation.model.Customer
import com.sourabh.hotelreservation.repository.CustomerRepository
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CancellationService(@Autowired private var customerRepository: CustomerRepository,
                          @Autowired var roomService: RoomService,
                          @Autowired var transactionService: TransactionService):ICancelRoomService {

    override fun getCustomer(id: Int): Customer? {
        return customerRepository.findById(id).orElseThrow { SomethingNotFoundException("No Room found for the id: $id") }
    }

    override fun cancelRoom(id: Int): String {
        var customer = getCustomer(id)
        if(!customer?.status!!)
            throw SomethingNotFoundException("Customer id not valid. Invalid id: $id")

        var room = roomService.findByType(customer.type)
        var basefare = room.price
        var refund = 0f
        var fullPay = customer.fullPay
        if(fullPay)
            refund = customer.totalFair - basefare
        customer.status = false
        var transaction = transactionService.getById(customer.cid)
        transaction.customer = customer
        transaction.amount = basefare
        transactionService.addOrUpdate(transaction)
        customerRepository.save(customer)
        roomService.updateRoomCount(room, 1)
        val obj:JSONObject= JSONObject()
        obj.put("Full-Payment", fullPay)
        obj.put("Base-Fare", basefare)
        obj.put("Refund", refund)
        return obj.toString()
    }
}