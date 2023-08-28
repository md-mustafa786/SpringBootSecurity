package com.example.Spring_Boot_Security.controlers;

import com.example.Spring_Boot_Security.dao.UserRepository;
import com.example.Spring_Boot_Security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController


public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user){
        if(userRepository.findByUsername(user.getUsername())!=null){
            return ResponseEntity.badRequest().body("Username already exist");
        }

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");

    }

    @GetMapping("/normal")
    public List<User> getAllUser(){
       return userRepository.findAll();
    }

    @GetMapping("/admin/{id}")
    public Optional<User> getById(@PathVariable Integer id){
       return userRepository.findById(id);
    }

}
