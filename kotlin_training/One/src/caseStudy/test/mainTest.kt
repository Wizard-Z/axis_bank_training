package caseStudy.test

import caseStudy.DAO.connectionClose
import caseStudy.DAO.getConnection
import caseStudy.model.book_room
import caseStudy.model.cancelBooking
import caseStudy.model.showDetails
import java.io.File
import java.lang.NumberFormatException

fun book(cid:Int){
    println("IN booking...(_)")
    book_room(cid)
}
fun cancel(){
    println("IN cancel...(_)")
    var quit= false
    var cid=0
    while (!quit) {
        try {
            println("Enter Customer id (c.id):\n>>>")
            cid = readLine()?.toInt() ?: -1 //null check
        } catch (e: NumberFormatException) {
            println("Invalid cid.. ${e.message}")
            cid =-1
        }
        if (cid>0)
            quit=true
    }
    cancelBooking(cid)
}

fun details(){
    println("...")
    showDetails()

}

fun main(){
    var quit:Boolean=false
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
                    quit = true;
                    //TODO save CID to file
                    File("file.txt").writeText(cid.toString())
                    println("Receipt id saved to file.")
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
    }

}