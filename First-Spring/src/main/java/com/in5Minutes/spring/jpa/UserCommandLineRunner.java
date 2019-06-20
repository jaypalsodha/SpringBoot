package com.in5Minutes.spring.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);
	@Autowired
	UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Command line runner");
		repository.save(new User("Hardip", "Admin"));
		repository.save(new User("jaypal", "User"));
		repository.save(new User("Pradip", "Admin"));

		for (User user : repository.findAll()) {
			log.info(user.toString());
		}
		log.info("Admin Users Are");
		log.info("------------------------------");
		for (User user : repository.findByRole("Admin")) {
			log.info(user.toString());
		}
		log.info("User with the particular name are");
		log.info("------------------------------");
		for (User user : repository.findByName("jaypal")) {
			log.info(user.toString());
		}
	}
}
