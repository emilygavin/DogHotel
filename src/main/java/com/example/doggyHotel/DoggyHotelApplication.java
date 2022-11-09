package com.example.doggyHotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoggyHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoggyHotelApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (DogRepository repository) {
		return args -> {
		};
	}

}
