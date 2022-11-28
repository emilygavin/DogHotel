package com.example.doggyHotel;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DogService {
    private final DogRepository dogRepository;
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public Dog addNewDog(Dog dog){
        return dogRepository.insert(dog);
    }
}