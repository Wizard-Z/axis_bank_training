package com.sourabh.hotelreservation.iservice

import com.sourabh.hotelreservation.model.Customer

interface ICancelRoomService {
    fun getCustomer(id: Int): Customer?
    fun cancelRoom(id: Int): String?
}