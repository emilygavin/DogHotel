package com.example.doggyHotel;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
@AllArgsConstructor
public class DogController {

    private DogService dogService;

    @GetMapping
    public List<Dog> fetchAllDogs(){
        return dogService.getAllDogs();
    }

    @GetMapping(value = "/find-by-email/{email}")
    public List<Dog> findDogsByEmail(@PathVariable String email) throws Exception {
        return dogService.findByEmail(email);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Dog registerNewDog (@RequestBody Dog dog) throws Exception {
        return dogService.addNewDog(dog);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteDog(@PathVariable String id) throws Exception {
        dogService.deleteDog(id);
    }
}
