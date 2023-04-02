package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@RepositoryRestResource
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findPersonById(Long id);

    Optional<Person> findPersonByName(String name);

}