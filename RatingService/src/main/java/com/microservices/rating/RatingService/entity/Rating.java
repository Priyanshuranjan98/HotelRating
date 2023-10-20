package com.microservices.rating.RatingService.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "rating")
public class Rating {
    @Id
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ratingId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "hotel_id")
    private int hotelId;
    @Column(name = "rating")
    private int rating;

    public Rating() {
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
