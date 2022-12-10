package com.example.doggyHotel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
	public void testCreateNewDog() throws Exception {
		Dog dog = new Dog();
		dog.setId("87654321");
		dog.setOwnerName("Cliodhna");
		dog.setPhoneNumber("0873883598");
		dog.setEmailAddress("cliodhnanee@hotmail.com");
		dog.setDogName("Amber");
		dog.setDogGender(Gender.FEMALE);
		dog.setBreed("Labrador");
		dog.setAge(10);

		assertThat(dogController.registerNewDog(dog)).isEqualTo(dog);
	}

	@Test
	public void testCreateNewDogPhoneNumberException() {
		Dog dog = new Dog();
		dog.setOwnerName("John Doe");
		dog.setPhoneNumber("73883598");
		dog.setEmailAddress("johndoe@hotmail.com");
		dog.setDogName("Jessie");
		dog.setDogGender(Gender.MALE);
		dog.setBreed("Husky");
		dog.setAge(6);
		Exception exception = assertThrows(Exception.class, () -> {
			dogController.registerNewDog(dog);
		});
		String expectedMessage = "Invalid Phone Number!";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void testCreateNewDogEmailException() {
		Dog dog = new Dog();
		dog.setOwnerName("Jane Doe");
		dog.setPhoneNumber("0873883598");
		dog.setEmailAddress("janedoe@hotmail.ie");
		dog.setDogName("Lucky");
		dog.setDogGender(Gender.MALE);
		dog.setBreed("Rottweiler");
		dog.setAge(6);
		Exception exception = assertThrows(Exception.class, () -> {
			dogController.registerNewDog(dog);
		});
		String expectedMessage = "Invalid Email Address!";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void testCreateNewDogOwnerNameException() {
		Dog dog = new Dog();
		dog.setOwnerName("Pa");
		dog.setPhoneNumber("0873883598");
		dog.setEmailAddress("patrickstar@hotmail.com");
		dog.setDogName("Bob");
		dog.setDogGender(Gender.MALE);
		dog.setBreed("Chihuahua");
		dog.setAge(9);
		Exception exception = assertThrows(Exception.class, () -> {
			dogController.registerNewDog(dog);
		});
		String expectedMessage = "Invalid Owner Name!";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}
}

