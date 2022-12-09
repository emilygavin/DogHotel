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

    public Dog addNewDog(Dog dog) throws Exception {
        if(dog.getEmailAddress().contains(".com") && dog.getEmailAddress().contains("@")) {
            if(dog.getPhoneNumber().contains("08") && dog.getPhoneNumber().length() > 5) {
                if(dog.getOwnerName().length() > 3 && dog.getOwnerName().length() < 20){
                    return dogRepository.insert(dog);
                }
                else{ throw new Exception("Invalid Owner Name!"); }
            }
            else { throw new Exception("Invalid Phone Number!"); }
        }
        else{ throw new Exception("Invalid Email Address!"); }
    }

    public void deleteDog(String id) throws Exception {
        if(!findById(id)){
            throw new Exception("Dog with this ID does not exist!");
        }
        else {
            dogRepository.deleteById(id);
        }
    }

    public List<Dog> findByEmail(String email) throws Exception {
        List<Dog> dogs = dogRepository.findByEmailAddress(email);
        if(dogs.isEmpty()){
            throw new Exception("No dogs with this email are in the database.");
        }
        else{
            return dogs;
        }
    }

    public boolean findById(String id){
        return dogRepository.existsById(id);
    }
}
