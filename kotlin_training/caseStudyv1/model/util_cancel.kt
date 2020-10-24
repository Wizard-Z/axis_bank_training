package model

import dao.CustDao
import dao.RoomsDao

fun cancelBooking(cid:Int){
    val cust = CustDao()
    println("Customer id: $cid")
    val cd=cust.getCustDetails(cid)
    if(cd==null)
        println("Invalid id.")
    else{
        val roomD = RoomsDao()
        val roomDetail = roomD.getRoomsDetails(cd.type)
        var bookingAmount = roomDetail?.price ?:0
        if (cd.full_pay=="Yes"){
            println("Your Booking amount is: $bookingAmount")
            println("Your refund amount is: ${cd.total_fair- bookingAmount}")
        }
        else {
            println("-Only Booking amount was paid so no REFUND-")
            bookingAmount=0;
        }
        cust.removeCust(cid, bookingAmount)
        if (roomDetail != null) {
            roomD.incRoom(roomDetail.type)
        }


    }
}