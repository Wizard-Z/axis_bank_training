package com.sourabh.demo.servicetest;


import com.sourabh.demo.exceptions.SomethingNotFoundException;
import com.sourabh.demo.model.Room;
import com.sourabh.demo.repository.RoomRepository;
import com.sourabh.demo.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class RoomServiceTest {
    @Autowired
    private RoomService roomService;
    @MockBean
    private RoomRepository roomRepository;

    @Test
    void getAllTest(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1,"Suit",1200,12,true));
        rooms.add(new Room(2,"Master-Suit",1600,7,true));
        rooms.add(new Room(3,"Single-Room",699,18,true));

        when(roomRepository.findAll()).thenReturn(rooms);
        Assertions.assertEquals(3, roomService.getAll().size());

    }

    @Test
    void getAllTest2(){
        List<Room> rooms = new ArrayList<>();
        when(roomRepository.findAll()).thenReturn(rooms);
        Assertions.assertThrows( SomethingNotFoundException.class,()-> roomService.getAll());

    }

    @Test
    void addOrUpdateTest(){
        Room returnedRoom = new Room(1,"Suit",1200,12,true);
        Room passedRoom = new Room(1,"Suit",1200,12,false);
        when(roomRepository.save(passedRoom)).thenReturn(returnedRoom);
        Assertions.assertEquals(returnedRoom.isAvailable(), roomService.addOrUpdate(passedRoom).isAvailable());
    }
    @Test
    void addOrUpdateVerifyTest(){
        Room room = new Room(1,"Suit",1200,12,true);
        roomService.addOrUpdate(room);
        verify(roomRepository,times(1)).save(room);
    }

    @Test
    void findByTypeAvailable() {
        Room room = new Room(1, "Suit", 1200, 12, true);
        when(roomRepository.findByType("Suit")).thenReturn(room);
        Assertions.assertTrue(roomService.findByTypeAvailable("Suit").isAvailable());
    }
    @Test
    void findByTypeAvailable2(){
        Room room = new Room(1,"Suit",1200,12,false);
        when(roomRepository.findByType("Suit")).thenReturn(room);
        Assertions.assertThrows( SomethingNotFoundException.class,()-> roomService.findByTypeAvailable("Suit"));
    }

    @Test
    void findByIdTest(){
        Room room = new Room(1, "Suit", 1200, 12, true);
        when(roomRepository.findById(1)).thenReturn(java.util.Optional.of(room));
        Assertions.assertEquals(room,roomService.findById(1));
    }
    @Test
    void findByIdAvailableTest(){
        Room room = new Room(1, "Suit", 1200, 12, false);
        when(roomRepository.findById(1)).thenReturn(java.util.Optional.of(room));
        Assertions.assertThrows(SomethingNotFoundException.class,()->roomService.findByIdAvailable(1));
    }
    @Test
    void getAllAvailableTest(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1,"Suit",1200,12,true));
        rooms.add(new Room(2,"Master-Suit",1600,7,true));
        rooms.add(new Room(3,"Single-Room",699,18,true));
        when(roomRepository.getAllAvailable()).thenReturn(rooms);
        Assertions.assertEquals(3,roomService.getAllAvailable().size());

    }
    @Test
    void updateRoomCountTest(){
        Room roomOld = new Room(1, "Suit", 1200, 12, true);
        int count = 1;
        Room roomNew = new Room(1, "Suit", 1200, 13, true);
        when(roomRepository.save(roomNew)).thenReturn(roomNew);
        roomService.updateRoomCount(roomOld,count);
        Assertions.assertEquals(roomNew.getLeft(),roomOld.getLeft());


    }













}
