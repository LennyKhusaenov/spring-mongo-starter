package com.example.khusaenov.fluxstarter.service

import com.example.khusaenov.fluxstarter.model.Contact
import com.example.khusaenov.fluxstarter.repository.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * @author Khusaenov on 10.08.2018
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/contacts")
class ContactController @Autowired constructor(private val contactRepository: ContactRepository) {

    @GetMapping(produces = arrayOf(APPLICATION_STREAM_JSON_VALUE))
    fun getContacts() = contactRepository.findAll()


    @PostMapping(produces = arrayOf(APPLICATION_STREAM_JSON_VALUE))
    fun saveContact(@RequestBody contact: Contact): Contact {
        contactRepository.save(contact)
        return contact
    }

//    @GetMapping(path = arrayOf("/{id}"), produces = arrayOf(APPLICATION_STREAM_JSON_VALUE))
//    fun getContactById(@PathVariable id: String): Optional<Contact> {
//        return contactRepository.findById(id)
//    }
//
//    @PutMapping(path = arrayOf("/{id}"), produces = arrayOf(APPLICATION_STREAM_JSON_VALUE))
//    fun updateContact(@PathVariable id: String, @RequestBody contact: Contact): Contact {
//
//        val c = contactRepository.findById(id).orElseThrow(???({ UnsupportedOperationException() }))
//        if (contact.name != null) {
//            c.setName(contact.name)
//        }
//        if (contact.address != null) {
//            c.setAddress(contact.address)
//        }
//        if (contact.city != null) {
//            c.setCity(contact.city)
//        }
//        if (contact.phone != null) {
//            c.setPhone(contact.phone)
//        }
//        if (contact.email != null) {
//            c.setEmail(contact.email)
//        }
//        contactRepository.save<Contact>(c)
//        return c
//    }
//
//    @DeleteMapping(path = arrayOf("/{id}"), produces = arrayOf(APPLICATION_JSON_VALUE))
//    fun deleteContact(@PathVariable id: String): String {
//        val contact = contactRepository.findById(id)
//                .orElseThrow(???({ UnsupportedOperationException() }))
//        contactRepository.delete(contact)
//
//        return "Success"
//    }
}