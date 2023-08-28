package com.example.Spring_Boot_Security.controlers;

import com.example.Spring_Boot_Security.dao.UserRepository;
import com.example.Spring_Boot_Security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody User user){
        User existingUser = userRepository.findByUsername(user.getUsername());

        if(existingUser == null  || !existingUser.getPassword().equals(user.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        return ResponseEntity.ok("Signin successful");
    }
}
