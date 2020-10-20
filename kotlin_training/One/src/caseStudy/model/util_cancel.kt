package caseStudy.model

import caseStudy.DAO.custDAO
import caseStudy.DAO.roomsDAO

fun cancelBooking(cid:Int){
    val cust = custDAO()
    println("Customer id: $cid")
    val cd=cust.getCustDetails(cid)
    if(cd==null)
        println("Invalid id.")
    else{
        val roomD = roomsDAO()
        val roomDetail = roomD.getRoomsDetails(cd.type)
        if (cd.full_pay=="Yes"){
            val bookingAmount = roomDetail?.price ?:0
            println("Your Booking amount is: $bookingAmount")
            println("Your refund amount is: ${cd.total_fair- bookingAmount}")
        }
        else
            println("-Only Booking amount was paid so no REFUND-")
        cust.removeCust(cid)
        if (roomDetail != null) {
            roomD.incRoom(roomDetail.type)
        }


    }
}