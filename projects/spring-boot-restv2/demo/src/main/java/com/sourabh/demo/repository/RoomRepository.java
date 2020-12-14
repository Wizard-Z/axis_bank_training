package com.sourabh.demo.repository;

import com.sourabh.demo.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends MongoRepository<Room,Integer> {

    Room findByType(String type);
    @Query(value="{available:true}")//,fields="{_id:0,}")
    List<Room> getAllAvailable();
}
