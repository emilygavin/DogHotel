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
	DogService dogService;

	@Test
	public void testFindAllDogs(){
		List<Dog> dog = dogController.fetchAllDogs();

		assertThat(dog).isEqualTo(dogController.fetchAllDogs());
	}

	@Test
	public void testFindFirstDog(){
		Dog dog = new Dog();

		dog.setId("87654321");
		dog.setOwnerName("Cliodhna");
		dog.setPhoneNumber("0873883598");
		dog.setEmailAddress("cliodhnanee@hotmail.com");
		dog.setDogName("Amber");
		dog.setDogGender(Gender.FEMALE);
		dog.setBreed("Labrador");
		dog.setAge(10);

		assertThat(dogController.fetchAllDogs().get(0)).isEqualTo(dog);
	}

	@Test
	public void testCreateNewDog() throws Exception {
		Dog dog = new Dog();
		dog.setId("98726543");
		dog.setOwnerName("Elsie");
		dog.setPhoneNumber("0863372615");
		dog.setEmailAddress("elisesantella@hotmail.com");
		dog.setDogName("Donnolly");
		dog.setDogGender(Gender.MALE);
		dog.setBreed("Labra-doodle");
		dog.setAge(2);

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

	@Test
	public void testCreateNewDogDeleteException() {
		Dog dog = new Dog();
		dog.setId("87676545");
		dog.setOwnerName("Lilly");
		dog.setPhoneNumber("0897762735");
		dog.setEmailAddress("lillyobrien@gmail.com");
		dog.setDogName("Billy");
		dog.setDogGender(Gender.MALE);
		dog.setBreed("Husky");
		dog.setAge(5);

		Exception exception = assertThrows(Exception.class, () -> {
			dogController.deleteDog("87676545");
		});
		String expectedMessage = "Dog with this ID does not exist!";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void testFindByEmailException() {
		Dog dog = new Dog();
		dog.setOwnerName("Patrick");
		dog.setPhoneNumber("0873883598");
		dog.setEmailAddress("patrickstar1@hotmail.com");
		dog.setDogName("B");
		dog.setDogGender(Gender.MALE);
		dog.setBreed("Chihuahua");
		dog.setAge(2);

		Exception exception = assertThrows(Exception.class, () -> {
			dogController.findDogsByEmail("patrickstar@hotmail.com");
		});
		String expectedMessage = "No dogs with this email are in the database.";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}
}

