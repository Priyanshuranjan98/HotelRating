package com.microservices.hotelService.hotelService.controller;

import com.microservices.hotelService.hotelService.entity.Hotel;
import com.microservices.hotelService.hotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/get/{id}")
    public Hotel getHotelById(@PathVariable int id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping
    @RequestMapping("/get")
    public List<Hotel> getAllHotel() {
        return hotelService.getAllHotel();
    }

    @PostMapping
    @RequestMapping("/create")
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }
}
