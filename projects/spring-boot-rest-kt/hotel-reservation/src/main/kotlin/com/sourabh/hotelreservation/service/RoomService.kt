package com.sourabh.hotelreservation.service

import com.sourabh.hotelreservation.exception.SomethingNotFoundException
import com.sourabh.hotelreservation.iservice.IRoomService
import com.sourabh.hotelreservation.model.Room
import com.sourabh.hotelreservation.repository.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoomService(@Autowired private var roomRepository: RoomRepository):IRoomService {

    override fun addOrUpdate(room:Room):Room{
        room.available=true
        return roomRepository.save(room);
    }

    override fun findById(id: Int): Room {
        return roomRepository.findById(id).orElseThrow { SomethingNotFoundException("No Room found for the id: $id") }
    }

    override fun findByIdAvailable(id: Int): Room {
        val room = findById(id)
        if(room.available)
            return room
        else
            throw SomethingNotFoundException("Room with ID $id not available")
    }

    override fun findByType(type: String): Room {
        return roomRepository.findByType(type) ?: throw SomethingNotFoundException("No room with type: $type")

    }

    override fun findByTypeAvailable(type: String): Room {
        val room = roomRepository.findByType(type)
        if (room == null || !room.available)
            throw SomethingNotFoundException("No room with type: $type")
        return room
    }

    override fun getAll():MutableList<Room>?{
        val rooms=roomRepository.findAll()
        if(rooms.isEmpty())
            throw SomethingNotFoundException("No room data available")
        return rooms
    }

    override fun getAllAvailable(): MutableList<Room> {
        val rooms = roomRepository.getAllAvailable()
        if (rooms.isEmpty())
            throw SomethingNotFoundException("NO ROOMS AVAILABLE");
        return rooms
    }

    override fun addAll(rooms:MutableList<Room>): MutableList<Room> {
        return roomRepository.insert(rooms)
    }

    override fun removeRoom(id: Int): Room {
        var roomDetails = findById(id)
        roomDetails.available=false
        return roomRepository.save(roomDetails)
    }

    override fun updateRoomCount(room: Room, count:Int) {
         room.left = room.left+count
        if(room.left == 0)
            room.available=false
        roomRepository.save(room)

    }


}