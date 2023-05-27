package com.boxofficenumbers.boxofficenumbers;


import com.boxofficenumbers.boxofficenumbers.model.person;
import com.boxofficenumbers.boxofficenumbers.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonRepo repo;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody person person){
        repo.save(person);
    }
}
