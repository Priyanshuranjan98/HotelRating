package com.example.microservice.userservice.external;

import com.example.microservice.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping("/rating/get/userId/{userId}")
    Rating[] getRating(@PathVariable int userId);
}
