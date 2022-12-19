package com.example.UsersBase.Controller;

import com.example.UsersBase.Model.Person;
import com.example.UsersBase.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person){
       personService.addPerson(person);
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestBody Person person){
        personService.deletePerson(person);
    }

    @PatchMapping("/person")
    public void editPerson(@RequestBody Person person){
        personService.editPerson(person);
    }


    @GetMapping("/person")
    public String getperson(@RequestBody Person person){
        return personService.getPersonById(person.getId()).toString();
    }

}
