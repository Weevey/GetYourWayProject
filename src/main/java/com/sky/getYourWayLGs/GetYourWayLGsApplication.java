package com.sky.getYourWayLGs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//added
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

import com.sky.getYourWayLGs.entities.User;
import com.sky.getYourWayLGs.repository.UserRepository;


@SpringBootApplication
public class GetYourWayLGsApplication {

	private static final Logger logger = LoggerFactory.getLogger(GetYourWayLGsApplication.class);


	@Autowired
	private UserRepository user_repository;

	public static void main(String[] args) {
		SpringApplication.run(GetYourWayLGsApplication.class, args);
		//		auto restart test comment
		logger.info("Hello Spring Boot");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Save demo data to database


			user_repository.save(new User("admin",
					"$2a$10$LmptYa4uWhkO/OO.lpmahO14w0WKBzyKQOAXeSrYal04KKt.OTcRu",
					"ADMIN"));

			user_repository.save(new User("user",
					"$2a$10$6CJhx.freP/GXr56EItYJeVc2r9P3o/ns/adeKBAuf8d65Y8qz2qi",
					"USER"));
		};
	}
}