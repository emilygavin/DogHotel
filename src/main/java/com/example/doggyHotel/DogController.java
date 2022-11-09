package com.example.doggyHotel;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dogs")
@AllArgsConstructor
public class DogController {

    private DogService dogService;

    @GetMapping
    public List<Dog> fetchAllDogs(){
        return dogService.getAllDogs();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dog registerNewPDog (@RequestBody Dog dog){
        return dogService.addNewDog(dog);
    }
}
