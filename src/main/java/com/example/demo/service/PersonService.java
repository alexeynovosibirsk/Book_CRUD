package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {return personRepository.findAll();}

    public Person update(Person person) {
        Person existingPerson = personRepository.findPersonById(person.getId());
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());
        existingPerson.setAge(person.getAge());
        return personRepository.save(existingPerson);
    }

    public Person findPersonByName(String name) {

        return personRepository.findPersonByName(name);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }



    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
