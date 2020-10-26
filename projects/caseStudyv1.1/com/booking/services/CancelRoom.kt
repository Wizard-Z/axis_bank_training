package com.booking.services


import com.booking.dao.CustomerDao
import com.booking.dao.RoomsDao
import com.booking.dao.TransactionDao
import com.booking.model.Customers
import com.booking.model.Rooms
import java.lang.NumberFormatException

class CancelRoom() {
    var cid: Int = 0
    var customerDetails: Customers? = null
    var roomDetails: Rooms? = null

    // input cid.
    // check valid
    // calculate refund
    // update customer table
    // update transaction table
    // update rooms table
    fun takeInput() {
        var quit = false
        while (!quit) {
            try {
                println("Enter Customer id (c.id):\n>>>")
                cid = readLine()?.toInt() ?: -1 //null check
            } catch (e: NumberFormatException) {
                println("Invalid cid.. ${e.message}")
                cid = -1
            }
            if (cid > 0)
                quit = true
        }
    }

    fun getCustomerInfo(): Customers? {
        println("Customer id: $cid")
        customerDetails = CustomerDao().getRow(cid)
        return if (customerDetails == null|| customerDetails!!.status==0) {
            println("Invalid id.")
            null
        } else
            customerDetails
    }

    fun calculateRefund(customer: Customers): Float {
        val roomType = customer.type
        roomDetails = RoomsDao().getDetails(roomType)
        var bookingAmount: Float = roomDetails?.price ?: 0.0F
        var refund: Float = 0F

        if (bookingAmount > 1) {
            if (customer.full_pay == "Yes") {
                println("Your Booking amount is: $bookingAmount")
                refund = customer.total_fair - bookingAmount
                println("Your refund amount is: ${customer.total_fair - bookingAmount}")

            } else {
                println("-Only Booking amount was paid so no REFUND-")
                refund = 0F;
            }
        } else
            println("Err... cancel().calculateRefund()")
        return refund
    }

    fun removeCustomer() {
        CustomerDao().changeStatus(cid)
    }

    fun updateTransactionTable(refund: Float) {
        val charges = (TransactionDao().getRow(cid)?.amount ?: 0F) - refund
        println(">>>\nRefund: $refund \t Charges: $charges\n>>>")
        if (charges>0)
            TransactionDao().update(cid, charges)
        else
            println("Err... cancel().updateTransactionTable()")
    }

    fun updateRoomsTable() {
        val roomType = customerDetails?.type
        if (roomType != null)
            RoomsDao().incrementAvailable(roomType)
        else
            println("Err... cancel().updateRoomTable()")
    }

}
