package com.example.UsersBase.Service;

import com.example.UsersBase.Model.Person;

public interface PersonService {

    void addPerson(Person person);

    void deletePerson(Person person);

    void editPerson(Person person);

    Person getPersonById(Long Id);
}
