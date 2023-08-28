package com.example.Spring_Boot_Security.services;

import com.example.Spring_Boot_Security.dao.UserRepository;
import com.example.Spring_Boot_Security.models.CustomUserDetail;
import com.example.Spring_Boot_Security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("No User");
        }

        return new CustomUserDetail(user);
    }
}
