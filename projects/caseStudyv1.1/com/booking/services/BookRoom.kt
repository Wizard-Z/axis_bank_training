package com.booking.services

import com.booking.dao.*
import com.booking.model.Customers
import com.booking.model.Rooms
import java.lang.NumberFormatException

//@Throws(Exception::class)

class BookRoom(private val cid: Int) {
    private var roomsDao: RoomsDao
    private var customerDao: CustomerDao
    var name: String?
    var type: String?
    var roomDetails: Rooms?
    var customer: Customers?

    init {
        println("---------------------------------------")
        roomsDao = RoomsDao()
        customerDao = CustomerDao();
        name = null
        type = null
        roomDetails = null
        customer = null
    }
        fun choices() {
            println("===Booking room===\n>>> $cid")
            println("----Rooms details are----\ntype:price:qty")// show only available
            roomsDao.showAvailable()//print all rooms choices

        }

        fun takeInput() {
            println("Enter your name:\n>>>")
            name = readLine().toString()
            println("Enter your room choice:\n>>>")
            type = readLine().toString()
            //
        }

        fun calculateFare() {
            roomDetails = type?.let { roomsDao.getDetails(it) }//TODO add check here.
            if (roomDetails != null) {
                val price = roomDetails?.price
                println("Room price is: $price")
                val days: Int = getDays()
                val fare = price?.let { payableAmount(it, days) }
                println("Total Money to pay.\n>>>$fare")
                var fullP: String? = null
                while (fullP == null) {
                    println("\n1.Full payment\t2.Booking amount?>>>")
                    fullP = validInput(readLine(), "1", "2")
                }
                fullP = if (fullP == "1")
                    "Yes"
                else
                    "No"
                var methodP: String? = null
                while (methodP == null) {
                    println("Select you payment gateway\n1. UPI\t 2. Cash\t3. NET-BANKING\n>>>")
                    methodP = validInput(readLine(), "1", "2", "3")
                }
                methodP = when (methodP) {
                    "1" -> "UPI"
                    "2" -> "CASH"
                    "3" -> "NET-BANKING"
                    else -> "Other"
                }
                if (fare != null) {
                    customer = name?.let { type?.let { it1 -> Customers(cid, it, it1, days, fare.toFloat(), fullP, methodP) } }
                }
            } else
                println("Err... (rooms info. cannot be fetched)!")
        }

        fun updateCustomerTable() {
            println("OBJ:$customer")
            if (customer != null) {
                customerDao.insertRow(customer)
                println("Your details are:\n>>> ${customerDao.getRow(cid)}")
            } else {
                println("Something happened...util_booking()-->BookRoom.calculateFare()")
            }

        }

        fun updateRoomsTable() {
            type?.let { roomsDao.decrementAvailable(it) }
            roomsDao.showAvailable()
        }

        fun updateTransactionTable() {
            val price: Float? = if (customer?.full_pay == "Yes") customer?.total_fair else roomDetails?.price
            if (price != null)
                customer?.let { TransactionDao().insertRow(it, price) }
        }


        private fun validInput(inp: String?, vararg valids: String): String? {
            if (inp in valids) return inp
            else
                return null

        }

        private fun getDays(): Int {
            var quit: Boolean = false
            var days: Int = 0
            while (!quit) {
                try {
                    println("Enter days:\n>>>")
                    days = readLine()?.toInt() ?: -1 //null check
                } catch (e: NumberFormatException) {
                    println("Invalid days.. ${e.message}")
                    days = -1
                }
                if (days > 0)
                    quit = true
            }
            return days
        }

        private fun payableAmount(price: Float, days: Int): Float {
            if (days >= 5) {
                println("-DISCOUNT-\n*Your one day stay is on us*\n")
                return (days - 1) * price
            } else {
                return days * price
            }


        }

    //
}

/*
TODO: Implement Singleton design
 */