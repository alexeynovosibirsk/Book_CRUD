package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private PersonService personService;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/update")
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    @GetMapping("/persons")
    public Iterable<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/persons/{name}")
    public Person findPersonByName(@PathVariable String name) {
        return personService.findPersonByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        personService.delete(id);
    }


}