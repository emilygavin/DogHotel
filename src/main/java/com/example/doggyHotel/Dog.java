package com.example.doggyHotel;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Dog {
    @Id
    private String id;
    private String ownerName;
    private String phoneNumber;
    private String emailAddress;
    private String dogName;
    private Gender dogGender;
    private String breed;
    private Integer age;

    public Dog(){

    }

    public Dog(String id, String ownerName, String phoneNumber, String emailAddress, String dogName, Gender dogGender, String breed, Integer age) {
        this.id = id;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.dogName = dogName;
        this.dogGender = dogGender;
        this.breed = breed;
        this.age = age;
    }
}
