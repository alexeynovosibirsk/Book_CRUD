package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

    Person findPersonById(long id);

    Person findPersonByName(String name);

}