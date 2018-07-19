package com.example.khuasenov.fluxstarter.repository;

import com.example.khuasenov.fluxstarter.model.Persons;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Khusaenov on 17.07.2018
 */
@Repository
public interface PersonRepository extends MongoRepository<Persons, String> {


    public List<Persons> findPersonByName();

    public List<Persons> findAll();

    public List<Persons> findByAge();


}
