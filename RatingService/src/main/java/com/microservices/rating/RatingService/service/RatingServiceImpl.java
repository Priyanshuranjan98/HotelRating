package com.microservices.rating.RatingService.service;

import com.microservices.rating.RatingService.dao.RatingDao;
import com.microservices.rating.RatingService.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingDao ratingDao;

    @Override
    public Rating createRating(Rating rating) {
        return ratingDao.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingDao.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(int userId) {
        return ratingDao.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(int hotelId) {
        return ratingDao.findByHotelId(hotelId);
    }


}
