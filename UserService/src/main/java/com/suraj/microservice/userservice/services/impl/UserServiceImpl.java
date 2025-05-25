package com.suraj.microservice.userservice.services.impl;

import com.suraj.microservice.userservice.entities.User;
import com.suraj.microservice.userservice.exceptions.UserNotFoundException;
import com.suraj.microservice.userservice.repositories.UserRepository;
import com.suraj.microservice.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id " + userId + " doesn't exist!"));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
