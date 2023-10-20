package com.microservices.rating.RatingService.service;

import com.microservices.rating.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating>getAllRating();
   List< Rating> getRatingByUserId(int userId);
    List<Rating> getRatingByHotelId(int hotelId);

}
