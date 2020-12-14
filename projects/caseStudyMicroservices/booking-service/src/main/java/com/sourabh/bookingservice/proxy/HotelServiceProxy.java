package com.sourabh.bookingservice.proxy;


import com.sourabh.bookingservice.model.Room;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotel-service")//,url = "localhost:8081")
@RibbonClient(name = "hotel-service")
public interface HotelServiceProxy {


}
