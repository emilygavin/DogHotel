package com.example.doggyHotel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
class DoggyHotelApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	DogController dogController;

	@Test
	public void testFindAllDogs(){
		List<Dog> dog = dogController.fetchAllDogs();

		assertThat(dog).isEqualTo(dogController.fetchAllDogs());
	}

	@Test
	public void testFindFirstDog(){
		Dog dog = new Dog();

		dog.setId("12345678");
		dog.setOwnerName("Emily");
		dog.setPhoneNumber("0838674899");
		dog.setEmailAddress("emilygavin@hotmail.com");
		dog.setDogName("Percy");
		dog.setDogGender(Gender.MALE);
		dog.setBreed("Red Setter");
		dog.setAge(7);

		assertThat(dogController.fetchAllDogs().get(0)).isEqualTo(dog);
	}

	@Test
	public void testCreateNewDog(){
		Dog dog = new Dog();
		dog.setId("87654321");
		dog.setOwnerName("Cliodhna");
		dog.setPhoneNumber("0873883598");
		dog.setEmailAddress("cliodhnanee@hotmail.com");
		dog.setDogName("Amber");
		dog.setDogGender(Gender.FEMALE);
		dog.setBreed("Labrador");
		dog.setAge(10);

		assertThat(dogController.registerNewPDog(dog)).isEqualTo(dog);
	}
}

