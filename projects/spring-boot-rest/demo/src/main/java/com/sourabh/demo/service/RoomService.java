package com.sourabh.demo.service;

import com.sourabh.demo.exceptions.SomethingNotFoundException;
import com.sourabh.demo.model.Room;
import com.sourabh.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;


    public Room findById(Integer id) {
        return roomRepository.findById(id).orElseThrow(() -> new SomethingNotFoundException("Room not found for the id: " + id));
    }
    public Room findByIdAvailable(Integer id) {
        Room room= roomRepository.findById(id).orElseThrow(() -> new SomethingNotFoundException("Room not found for the id: " + id));
        if(room.isStatus())
            return room;
        else
            throw new SomethingNotFoundException("Room of specified type not available");
    }

    public Room findByType(String type) {
        Room rooms = roomRepository.findByType(type);
        if (rooms == null)
            throw new SomethingNotFoundException("No Room with type: " + type);
        return roomRepository.findByType(type);

    }
    public Room findByTypeAvailable(String type) {
        Room rooms = roomRepository.findByType(type);
        if (rooms == null || !rooms.isStatus())
            throw new SomethingNotFoundException("No Room with type: " + type);
        return roomRepository.findByType(type);

    }

    public List<Room> getAll() {
        List<Room> rooms=roomRepository.findAll();
        if (rooms.isEmpty())
            throw new SomethingNotFoundException("No Rooms data available");
        return rooms;
    }
    public List<Room> getAllAvailable() {
        List<Room> rooms = roomRepository.getAllAvailable();
        if (rooms.isEmpty())
            throw new SomethingNotFoundException("NO ROOMS AVAILABLE");
        return rooms;
    }

    public Room addOrUpdate(Room room) {
        room.setStatus(true);
        return roomRepository.save(room);
    }

    public List<Room> addAll(List<Room> rooms) {
        return roomRepository.insert(rooms);
    }

    public Room removeRoom(int id) {
        Room roomDetails = findById(id);
        roomDetails.setStatus(false);
        return roomRepository.save(roomDetails);
    }
    public void updateRoomCount(Room room,int count){
        int updatedCount = room.getQty()+count;
        room.setQty(updatedCount);
        roomRepository.save(room);

    }

}
