package model

import dao.RoomsDao
import dao.*
import java.lang.NumberFormatException

@Throws(Exception::class)
fun calFare(price:Int,days:Int):Int{
    if (days>=5){
        println("-DISCOUNT-\n*Your one day stay is on us*\n")
        return (days-1)*price
    }
    else{
        return days*price
    }



}
fun book_room(cid:Int){
    println("===Booking room===\n>>> $cid")
    //show room details
 //step 2 load the driver


    println("----Rooms details are----\ntype:price:qty")// show only available
    val rooms_dao = RoomsDao()
    rooms_dao.showAll()//print all rooms choices
    // user inputs
    println("Enter your name:\n>>>")
    val cname= readLine().toString()
    println("Enter your room choice:\n>>>")
    val type = readLine().toString()
    //take choice and fetch room object
    val roomDetails:Rooms?=rooms_dao.getRoomsDetails(type)//TODO add check here.
    val cust:CustDao=CustDao()
    if (roomDetails!=null)
    {
        val price=roomDetails.price
        println("Room price is: $price")
        val days:Int= getDays()
        val fare=calFare(price,days)
        println("Total Money to pay.\n>>>$fare")
        var fullP:String?=null
        while (fullP==null){
            println("\n1.Full payment\t2.Booking amount?>>>")
            fullP= validInput(readLine(), "1","2")
        }
        fullP=if(fullP=="1")
            "Yes"
        else
            "No"
        var methodP:String?=null
        while (methodP==null) {
            println("Select you payment gateway\n1. UPI\t 2. Cash\t3. NET-BANKING\n>>>")
            methodP= validInput(readLine(),"1","2","3")
        }
        methodP = when(methodP){
            "1"->"UPI"
            "2" ->"CASH"
            "3" ->"NET-BANKING"
            else ->"Other"
        }
        //val cid,name:String,type:String,days:Int,
        //total_fair:Int,full_pay:String,val pay_method:String
        val c:Customers= Customers(cid,cname,type,days,fare.toFloat(),fullP,methodP)
        println("OBJ:$c")
        cust.insertCust(c,roomDetails.price)
        println("Your details are:\n>>> ${cust.getCustDetails(cid)}")

        //cust.showAll()
        //rooms_dao.descTable()
        //cust.descTable()
        rooms_dao.decRoom(type)
        rooms_dao.showAll()
        //cust.showAll()

    }
    else{
        println("Something happened...util_booking()")
    }

}
fun validInput(inp:String?,vararg valids:String): String?{
    if (inp in valids) return inp
    else
        return null

}
fun getDays():Int{
    var quit:Boolean = false
    var days:Int=0
    while (!quit) {
        try {
            println("Enter days:\n>>>")
            days = readLine()?.toInt() ?: -1 //null check
        } catch (e: NumberFormatException) {
            println("Invalid days.. ${e.message}")
            days =-1
        }
        if (days>0)
            quit=true
    }
    return days
}