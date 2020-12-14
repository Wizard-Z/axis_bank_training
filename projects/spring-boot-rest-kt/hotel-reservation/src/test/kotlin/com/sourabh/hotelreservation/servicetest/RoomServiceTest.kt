package com.sourabh.hotelreservation.servicetest

import com.sourabh.hotelreservation.exception.SomethingNotFoundException
import com.sourabh.hotelreservation.model.Room
import com.sourabh.hotelreservation.repository.RoomRepository
import com.sourabh.hotelreservation.service.RoomService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.util.*


@SpringBootTest
class RoomServiceTest {
    @InjectMocks
    val roomService:RoomService?=null
    @Mock
    var roomRepository:RoomRepository?=null

    @Test
    fun getAllTest() {
        val rooms: MutableList<Room> = ArrayList<Room>()
        rooms.add(Room(1, "Suit", 1200F, 12, true))
        rooms.add(Room(2, "Master-Suit", 1600F, 7, true))
        rooms.add(Room(3, "Single-Room", 699F, 18, true))
        Mockito.`when`(roomRepository!!.findAll()).thenReturn(rooms)
        Assertions.assertEquals(3, roomService!!.getAll()!!.size)
    }

    @Test
    fun getAllTest2() {
        val rooms: List<Room> = ArrayList()
        Mockito.`when`(roomRepository!!.findAll()).thenReturn(rooms)
        Assertions.assertThrows(SomethingNotFoundException::class.java, Executable { roomService!!.getAll() })
    }

    @Test
    fun addOrUpdateTest() {
        val returnedRoom = Room(1, "Suit", 1200F, 12, true)
        val passedRoom = Room(1, "Suit", 1200F, 12, false)
        Mockito.`when`(roomRepository!!.save(passedRoom)).thenReturn(returnedRoom)
        Assertions.assertEquals(returnedRoom.available, roomService!!.addOrUpdate(passedRoom).available)
    }



    @Test
    fun findByTypeAvailable() {
        val room = Room(1, "Suit", 1200F, 12, true)
        Mockito.`when`(roomRepository!!.findByType("Suit")).thenReturn(room)
        Assertions.assertTrue(roomService!!.findByTypeAvailable("Suit").available)
    }
    @Test
    fun findByTypeAvailable2() {
        val room = Room(1, "Suit", 1200F, 12, false)
        Mockito.`when`(roomRepository!!.findByType("Suit")).thenReturn(room)
        Assertions.assertThrows(SomethingNotFoundException::class.java) { roomService!!.findByTypeAvailable("Suit")}
        }

    @Test
    fun findByIdAvailableTest() {
        val room = Room(1, "Suit", 1200F, 12, false)
        Mockito.`when`(roomRepository!!.findById(1)).thenReturn(Optional.of(room))
        Assertions.assertThrows(SomethingNotFoundException::class.java) { roomService!!.findByIdAvailable(1) }
    }

    @Test
    fun getAllAvailableTest() {
        val rooms: MutableList<Room> = ArrayList()
        rooms.add(Room(1, "Suit", 1200F, 12, true))
        rooms.add(Room(2, "Master-Suit", 1600F, 7, true))
        rooms.add(Room(3, "Single-Room", 699F, 18, true))
        Mockito.`when`(roomRepository!!.getAllAvailable()).thenReturn(rooms)
        Assertions.assertEquals(3, roomService!!.getAllAvailable().size)
    }

    @Test
    fun updateRoomCountTest() {
        val roomOld = Room(1, "Suit", 1200F, 12, true)
        val count = 1
        val roomNew = Room(1, "Suit", 1200F, 13, true)
        Mockito.`when`(roomRepository!!.save(roomNew)).thenReturn(roomNew)
        roomService!!.updateRoomCount(roomOld, count)
        Assertions.assertEquals(roomNew.left, roomOld.left)
    }


}