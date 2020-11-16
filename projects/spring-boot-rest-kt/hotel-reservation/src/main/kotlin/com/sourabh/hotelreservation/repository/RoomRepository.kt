package com.sourabh.hotelreservation.repository

import com.sourabh.hotelreservation.model.Room
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository:MongoRepository<Room,Int> {
    fun findByType(type:String):Room?
    @Query(value="{available:true}")
    fun getAllAvailable():MutableList<Room>
}