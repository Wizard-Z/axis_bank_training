package com.booking.services

import com.booking.dao.CustomerDao
import com.booking.dao.RoomsDao
import com.booking.dao.TransactionDao
import com.booking.model.Rooms
import java.lang.NumberFormatException

fun showDetails() {
    println("In showDetails()\n1. Show occupants\n2. DateWise/typeWise Booking\n3. Avail Rooms\n" +
            "4. Customer Table\n5. Insert in Rooms Table\n6. Show Transactions\n7. Rooms Table")
    val custdao = CustomerDao()
    val roomdao = RoomsDao()
    val transactiondao = TransactionDao()
    var ch = readLine()
    while (ch !in listOf("1", "2", "3", "4", "5","6","7")) {
        println("Invalid..")
        println("1. Show occupants\n2. DateWise/typeWise Booking\n3. Avail Rooms\n" +
                "4. Customer Table\n5. Insert in Rooms Table\n6. Show Transactions\n7. Rooms Table")
        ch = readLine()
    }
    when (ch) {
        "1" -> {
            println("Showing occupant counts")
            custdao.groupBy("type", "Occupants : room-type")
        }
        "2" -> {
            println("Showing booking datewise and type")
            custdao.groupBy2("book_date,type", "COUNT : Booking date : room-type")
        }
        "3" -> {
            println("\nShowing hotel table(only available rooms) \n")
            roomdao.showAvailable()
        }
        "4" -> {
            println("\nShowing customer table\n")
            custdao.showAll()
        }
        "5" -> {
            println("Insert to Rooms table\n>>>")
            println("Enter Room type\n>>>")
            val type: String = readLine() ?: "unnamed"
            var price: Float = 0F
            var qty: Int = 0
            var quit = false
            while (!quit) {
                try {
                    println("Enter Price :\n>>>")
                    price = readLine()?.toFloat() ?: -1F //null check
                    println("Enter Qty :\n>>>")
                    qty = readLine()?.toInt() ?: -1
                } catch (e: NumberFormatException) {
                    println("Invalid .. ${e.message}")
                    price = -1F
                    qty = -1
                }
                if (price > 0 && qty > 0)// valid input received
                    quit = true
            }
            val room: Rooms = Rooms(type, price, qty)
            roomdao.insertRow(room)
        }
        "6" -> transactiondao.showTransactions()
        "7" -> roomdao.showAll()
        else -> println("Invalid choice..")
    }
}




