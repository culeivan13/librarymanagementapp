package com.suraj.microservice.userservice.services;

import com.suraj.microservice.userservice.entities.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    User saveUser(User user);
}
