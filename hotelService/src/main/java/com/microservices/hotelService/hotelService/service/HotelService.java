package com.microservices.hotelService.hotelService.service;

import com.microservices.hotelService.hotelService.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel getHotelById(int id);

    List<Hotel> getAllHotel();

    Hotel createHotel(Hotel hotel);

}
