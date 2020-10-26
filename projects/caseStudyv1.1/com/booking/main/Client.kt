package com.booking.main

import com.booking.dao.connectionClose
import com.booking.dao.getConnection
import com.booking.services.BookRoom
import com.booking.services.CancelRoom
import com.booking.services.showDetails
import java.io.File


fun book(cid:Int){
    println("IN booking...(_)")
    val booker = BookRoom(cid)
    booker.choices()
    booker.takeInput()
    booker.calculateFare()
    booker.updateCustomerTable()
    booker.updateRoomsTable()
    booker.updateTransactionTable()
}
fun cancel(){
    println("IN cancel...(_)")
    val cancelObj = CancelRoom()
    cancelObj.takeInput()
    val customer = cancelObj.getCustomerInfo()
    if (customer!=null){
        val refund = cancelObj.calculateRefund(customer)
        cancelObj.removeCustomer()
        cancelObj.updateTransactionTable(refund)
        cancelObj.updateRoomsTable()
    }
    else
        println("Err.. customer not available.")
}

fun details(){
    println("...")
    showDetails()

}

fun main(){
    var quit=false
    var ch:String?
    var cid:Int=File("file.txt").readText().toInt()
    val dbName = "hbook"
    getConnection(dbName)
    try {
        while (!quit) {
            println("\n>>>\nEnter..\n1: Book\n2: Cancel\n3: Hotel Status\nq:QUIT:\n>>>")
            ch = readLine()
            while (ch !in listOf("1", "2", "3", "q")) {
                println("Invalid\n:Enter..\n\n1: Book\n2: Cancel\n3: Hotel Status\nq:QUIT:\n>>>")
                ch = readLine()
            }
            when (ch) {
                "1" -> book(cid++)//(cid++)
                "2" -> cancel()
                "3" -> details()
                "q" -> {
                    quit = true

                }

            }

        }
    }
    catch(e:Exception){
        println("Err. : ${e.message}")
        //println(e.printStackTrace())
    }
    finally {
        println("Done!!")
        connectionClose()
        File("file.txt").writeText(cid.toString())
        println("Receipt id saved to file.")
    }

}