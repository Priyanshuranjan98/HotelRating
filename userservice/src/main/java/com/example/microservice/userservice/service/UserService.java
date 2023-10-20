package com.example.microservice.userservice.service;

import com.example.microservice.userservice.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int userId);

   List< User> getAllUser();

    User saveUser(User user);

}
