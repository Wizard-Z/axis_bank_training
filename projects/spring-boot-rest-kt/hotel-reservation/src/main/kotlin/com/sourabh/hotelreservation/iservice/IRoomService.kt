package com.sourabh.hotelreservation.iservice

import com.sourabh.hotelreservation.model.Room

interface IRoomService {
    fun findById(id:Int): Room
    fun findByIdAvailable(id:Int):Room
    fun findByType(type:String):Room
    fun findByTypeAvailable(type:String):Room
    fun getAll():MutableList<Room>?
    fun getAllAvailable(): MutableList<Room>?
    fun addOrUpdate(room:Room):Room
    fun addAll(rooms:MutableList<Room>):MutableList<Room>
    fun removeRoom(id:Int):Room
    fun updateRoomCount(room:Room,count:Int)

}