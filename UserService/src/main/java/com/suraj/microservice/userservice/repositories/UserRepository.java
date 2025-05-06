package com.suraj.microservice.userservice.repositories;

import com.suraj.microservice.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
