package com.example.UsersBase.Service;

import com.example.UsersBase.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.UsersBase.Model.Person;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.deleteById(person.getId());
    }

    @Override
    public void editPerson(Person person) {
        Person entity = personRepository.findById(person.getId()).get();

        if(person.getName() != null)
            entity.setName(person.getName());

        if(person.getSurname() != null)
            entity.setSurname(person.getSurname());

        if(person.getAge() != 0)
            entity.setAge(person.getAge());

        if (person.getDateOfBirth() != null)
            entity.setDateOfBirth(person.getDateOfBirth());

        personRepository.save(entity);
    }

    @Override
    public Person getPersonById(Long Id) {
        return personRepository.findById(Id).get();
    }

}
