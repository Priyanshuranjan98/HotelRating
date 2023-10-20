package com.example.microservice.userservice.service;

import com.example.microservice.userservice.entity.Hotel;
import com.example.microservice.userservice.entity.Rating;
import com.example.microservice.userservice.entity.User;
import com.example.microservice.userservice.external.HotelService;
import com.example.microservice.userservice.external.RatingService;
import com.example.microservice.userservice.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RatingService ratingService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUserById(int userId) {
        User user = userRepo.findByUserId(userId);
        //Rating[] userRating = restTemplate.getForObject("http://RATING-SERVICE/rating/get/userId/" + user.getUserId(), Rating[].class);
        Rating[] userRating= ratingService.getRating(user.getUserId());
        List<Rating> ratingList = Arrays.stream(userRating).toList();
        user.setRating(ratingList);
        ratingList.forEach(rating -> {
            //Hotel hotelRating = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/get/" + rating.getHotelId(), Hotel.class);
            Hotel hotelRating=  hotelService.getHotel(rating.getHotelId());
            user.setHotel(Collections.singletonList(hotelRating));
            logger.info(" {} ", hotelRating);
        });
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }
}
