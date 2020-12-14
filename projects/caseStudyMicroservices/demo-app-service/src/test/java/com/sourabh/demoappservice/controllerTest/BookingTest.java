package com.sourabh.demoappservice.controllerTest;

import com.sourabh.demoappservice.controller.BookingController;
import com.sourabh.demoappservice.model.Room;
import com.sourabh.demoappservice.proxy.HotelServiceProxy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BookingTest {
    @Autowired
    BookingController bookingController;
    @MockBean
    HotelServiceProxy hotelServiceProxy;

    @Test
    void echoTest(){
        assertEquals("Hello All!!!",bookingController.echo());
    }
    @Test
    void getAllTest(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1,"Suit",1200,12,true));
        rooms.add(new Room(2,"Master-Suit",1600,7,true));
        rooms.add(new Room(3,"Single-Room",699,18,true));

        when(hotelServiceProxy.getAllRooms()).thenReturn(rooms);
        Assertions.assertEquals(3, bookingController.getAll().size());

    }
    @Test
    void getAllAvailableTest(){
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1,"Suit",1200,12,true));
        rooms.add(new Room(2,"Master-Suit",1600,7,true));

        when(hotelServiceProxy.getAllAvailable()).thenReturn(rooms);
        Assertions.assertEquals(2, bookingController.getAllAvailable().size());

    }



}
