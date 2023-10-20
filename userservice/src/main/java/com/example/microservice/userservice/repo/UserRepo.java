package com.example.microservice.userservice.repo;

import com.example.microservice.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    User findByUserId(int userId);

    List<User> findAll();

}
