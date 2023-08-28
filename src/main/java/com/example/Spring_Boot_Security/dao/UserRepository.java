package com.example.Spring_Boot_Security.dao;

import com.example.Spring_Boot_Security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
