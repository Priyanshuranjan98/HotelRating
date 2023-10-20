package com.example.microservice.userservice.external;

import com.example.microservice.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotel/get/{hotelId}")
    Hotel getHotel(@PathVariable int hotelId);

}
