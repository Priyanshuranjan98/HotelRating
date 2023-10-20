package com.microservices.hotelService.hotelService.service;

import com.microservices.hotelService.hotelService.entity.Hotel;
import com.microservices.hotelService.hotelService.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel getHotelById(int id) {
        Optional<Hotel> hotel = hotelRepo.findById(id);
        if(hotel.isPresent()) {
            return hotel.get();
        }else{
            throw new RuntimeException("Hotel Details Not Found for ID : " + id);
        }
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

}
