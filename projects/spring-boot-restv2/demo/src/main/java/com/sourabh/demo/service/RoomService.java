package com.sourabh.demo.service;

import com.sourabh.demo.exceptions.SomethingNotFoundException;
import com.sourabh.demo.iservice.IRoomService;
import com.sourabh.demo.model.Room;
import com.sourabh.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class RoomService implements IRoomService {

    @Autowired
    RoomRepository roomRepository;


    public Room findById(Integer id) {
        return roomRepository.findById(id).orElseThrow(() -> new SomethingNotFoundException("Room not found for the id: " + id));
    }
    public Room findByIdAvailable(Integer id) {
        Room room= roomRepository.findById(id).orElseThrow(() -> new SomethingNotFoundException("Room not found for the id: " + id));
        if(room.isAvailable())
            return room;
        else
            throw new SomethingNotFoundException("Room of specified type not available");
    }

    public Room findByType(String type) {
        Room room = roomRepository.findByType(type);
        if (room == null)
            throw new SomethingNotFoundException("No Room with type: " + type);
        return room;

    }
    public Room findByTypeAvailable(String type) {
        Room room = roomRepository.findByType(type);
        if (room == null || !room.isAvailable())
            throw new SomethingNotFoundException("No Room with type: " + type);
        return room;

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
        room.setAvailable(true);
        return roomRepository.save(room);
    }

    public List<Room> addAll(List<Room> rooms) {
        return roomRepository.insert(rooms);
    }

    public Room removeRoom(int id) {
        Room roomDetails = findById(id);
        roomDetails.setAvailable(false);
        return roomRepository.save(roomDetails);
    }
    public void updateRoomCount(Room room,int count){
        int updatedCount = room.getLeft()+count;
        room.setLeft(updatedCount);
        roomRepository.save(room);

    }

}
