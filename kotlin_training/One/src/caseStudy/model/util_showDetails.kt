package caseStudy.model

import caseStudy.DAO.custDAO
import caseStudy.DAO.roomsDAO
import java.lang.NumberFormatException

fun showDetails() {
    println("In showDetails()\n1. Show occupants\n2. DateWise/typeWise Booking\n3. Avail Rooms\n" +
            "4. Customer Table\n5. Insert in Rooms Table\n6. Show Transactions")
    val custdao = custDAO()
    val roomdao = roomsDAO()
    var ch = readLine()
    while (ch !in listOf("1", "2", "3", "4", "5","6")) {
        println("Invalid..")
        println("1. Show occupants\n2. DateWise/typeWise Booking\n3. Avail Rooms\n" +
                "4. Customer Table\n5. Insert in Rooms Table\n6. Show Transactions")
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
            roomdao.showAll()
        }
        "4" -> {
            println("\nShowing customer table\n")
            custdao.showAll()
        }
        "5" -> {
            println("Insert to Rooms table\n>>>")
            println("Enter Room type\n>>>")
            val type: String = readLine() ?: "unnamed"
            var price: Int = 0
            var qty: Int = 0
            var quit = false
            while (!quit) {
                try {
                    println("Enter Price :\n>>>")
                    price = readLine()?.toInt() ?: -1 //null check
                    println("Enter Qty :\n>>>")
                    qty = readLine()?.toInt() ?: -1
                } catch (e: NumberFormatException) {
                    println("Invalid .. ${e.message}")
                    price = -1
                    qty = -1
                }
                if (price > 0 && qty > 0)// valid input received
                    quit = true
            }
            val room: Rooms = Rooms(type, price, qty)
            roomdao.insertRoom(room)
        }
        "6" -> roomdao.showTrans()
        else -> println("Invalid choice..")
    }
}




