package com.sourabh.demoappservice.proxy;

import com.sourabh.demoappservice.model.Room;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "hotel-service")//,url = "localhost:8081")
@RibbonClient(name = "hotel-service")
public interface HotelServiceProxy {
    @GetMapping("/api/rooms")
    public List<Room> getAllRooms();
//
//    @GetMapping("/api/rooms-type/{type}")
//    public Room findByType(@PathVariable String type);

    @GetMapping("/api/rooms/available")
    public List<Room> getAllAvailable();

    @GetMapping("/api/rooms/id/{id}")
    public Room findById(@PathVariable int id);

    @PostMapping("/api/rooms/{id}")
    public Room removeRoom(@PathVariable int id);
    @PostMapping("/api/rooms/update-count/{id}/{value}")
    public Room updateRoomCount(@PathVariable int id,@PathVariable int value);

    @PostMapping("/api/rooms")
    public Room addRoom(@RequestBody Room room);
}
