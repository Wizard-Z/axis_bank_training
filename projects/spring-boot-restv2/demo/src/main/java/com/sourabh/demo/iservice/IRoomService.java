package com.sourabh.demo.iservice;

import com.sourabh.demo.model.Room;

import java.util.List;

public interface IRoomService {
    public Room findById(Integer id);
    public Room findByIdAvailable(Integer id);
    public Room findByType(String type);
    public Room findByTypeAvailable(String type);
    public List<Room> getAll();
    public List<Room> getAllAvailable();
    public Room addOrUpdate(Room room);
    public List<Room> addAll(List<Room> rooms);
    public Room removeRoom(int id);
    public void updateRoomCount(Room room,int count);
}
