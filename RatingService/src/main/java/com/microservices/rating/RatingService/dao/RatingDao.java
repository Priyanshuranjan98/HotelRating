package com.microservices.rating.RatingService.dao;

import com.microservices.rating.RatingService.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingDao extends JpaRepository<Rating,Integer> {
    List<Rating> findByUserId(int userId);
    List<Rating> findByHotelId(int hotelId);
}
