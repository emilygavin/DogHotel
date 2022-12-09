package com.example.doggyHotel;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DogRepository extends MongoRepository<Dog, String> {
    List<Dog> findByEmailAddress(String email);
}
