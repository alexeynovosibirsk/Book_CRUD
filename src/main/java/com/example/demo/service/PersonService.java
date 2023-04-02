package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> findAll() {return personRepository.findAll();}

    public Person findById(long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElseThrow(() -> new PersonNotFoundException(String.format("Person with Id: %s is not found", id)));
    }

    public Person findPersonByName(String name) {
        Optional<Person> optionalPerson = personRepository.findPersonByName(name);
        return optionalPerson.orElseThrow(() -> new PersonNotFoundException(String.format("Person with name: %s is not found", name)));
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person person) {
        Person existingPerson = findById(person.getId());
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());
        existingPerson.setAge(person.getAge());
        return personRepository.save(existingPerson);
    }

    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
