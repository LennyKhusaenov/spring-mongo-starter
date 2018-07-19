package com.example.khuasenov.fluxstarter.service;

import com.example.khuasenov.fluxstarter.model.Persons;
import com.example.khuasenov.fluxstarter.repository.PersonRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Khusaenov on 17.07.2018
 */

@RestController
public class PersonRequestHandler {

    private final PersonRepository personRepository;

    @Autowired
    public PersonRequestHandler(
            PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(path = "/persons", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public List<Persons> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping(path = "/person", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public Persons getPerson() {
        Persons person = new Persons();
        person.setAge(24);
        person.setId(UUID.randomUUID().toString());
        person.setName("Leniz");
        person.setSurname("Khusaenov");
        return person;
    }

}
