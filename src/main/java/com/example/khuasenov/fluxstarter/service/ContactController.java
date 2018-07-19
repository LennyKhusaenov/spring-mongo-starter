package com.example.khuasenov.fluxstarter.service;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.khuasenov.fluxstarter.model.Contact;
import com.example.khuasenov.fluxstarter.repository.ContactRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Khusaenov on 18.07.2018
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/contacts")
public class ContactController {


    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(
            ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Iterable<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Contact saveContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Optional<Contact> getContactById(@PathVariable String id) {
        return contactRepository.findById(id);
    }

    @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Contact updateContact(@PathVariable String id, @RequestBody Contact contact) {

        Contact c = contactRepository.findById(id).orElseThrow(UnsupportedOperationException::new);
        if (contact.getName() != null) {
            c.setName(contact.getName());
        }
        if (contact.getAddress() != null) {
            c.setAddress(contact.getAddress());
        }
        if (contact.getCity() != null) {
            c.setCity(contact.getCity());
        }
        if (contact.getPhone() != null) {
            c.setPhone(contact.getPhone());
        }
        if (contact.getEmail() != null) {
            c.setEmail(contact.getEmail());
        }
        contactRepository.save(c);
        return c;
    }

    @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public String deleteContact(@PathVariable String id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(UnsupportedOperationException::new);
        contactRepository.delete(contact);

        return "Success";
    }


}
