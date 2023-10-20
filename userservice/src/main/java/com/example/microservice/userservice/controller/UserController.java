package com.example.microservice.userservice.controller;

import com.example.microservice.userservice.entity.User;
import com.example.microservice.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    @RequestMapping("/get/{id}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    public User ratingHotelFallback(int id,Exception e) {
        User user = new User();
        user.setUserId(444);
        user.setName("Service IS Down");
        user.setAbout("SERVICE IS DOWN PLEASE WAIT....");
        return user;
    }

    @GetMapping
    @RequestMapping("/get")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

}
