package com.example.khuasenov.fluxstarter.repository;

import com.example.khuasenov.fluxstarter.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Khusaenov on 18.07.2018
 */
@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {

    public Contact getContactById(String id);
}
