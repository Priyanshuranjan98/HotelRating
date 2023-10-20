package com.microservices.rating.RatingService.controller;

import com.microservices.rating.RatingService.entity.Rating;
import com.microservices.rating.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")

    public Rating createRating(@RequestBody Rating rating) {
        return ratingService.createRating(rating);
    }

    @GetMapping("/getAll")
    public List<Rating> getAllRating() {
        return ratingService.getAllRating();
    }

    @GetMapping("/get/userId/{userId}")
    public List<Rating> getRatingByUserId(@PathVariable int userId) {
        return ratingService.getRatingByUserId(userId);
    }

    @GetMapping("/get/hotelId/{hotelId}")
    public List<Rating> getRatingByHotelId(@PathVariable int hotelId) {
        return ratingService.getRatingByHotelId(hotelId);
    }
}
