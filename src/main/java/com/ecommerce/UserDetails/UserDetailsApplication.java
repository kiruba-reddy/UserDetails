package com.ecommerce.UserDetails;

import com.ecommerce.UserDetails.Repository.UserRepository;
import com.ecommerce.UserDetails.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserDetailsApplication implements CommandLineRunner{
	@Autowired
	UserRepository userRepo;
	public static void main(String[] args) {

		SpringApplication.run(UserDetailsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User first = new User();
		first.setName("kiruba");
		first.setEmail("vkirubanandan007@gmail.com");
		first.setPhone("8838561134");
		userRepo.save(first);
		User second = new User();
		second.setName("kiran");
		second.setEmail("kiran@gmail.com");
		second.setPhone("9944447012");
		userRepo.save(second);
		User third = new User();
		third.setName("siva");
		third.setEmail("siva@gmail.com");
		third.setPhone("9361880171");
		userRepo.save(third);
	}
}
