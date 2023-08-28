package com.example.Spring_Boot_Security;

import com.example.Spring_Boot_Security.dao.UserRepository;
import com.example.Spring_Boot_Security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setId(1);
		user.setUsername("Mustafa");
		user.setPassword(this.bCryptPasswordEncoder.encode("1234"));
		user.setRole("ROLE_ADMIN");
		this.userRepository.save(user);


		User user1 = new User();
		user1.setId(2);
		user1.setUsername("Adil");
		user1.setPassword(this.bCryptPasswordEncoder.encode("abcd"));
		user1.setRole("ROLE_NORMAL");
		this.userRepository.save(user1);
	}
}
