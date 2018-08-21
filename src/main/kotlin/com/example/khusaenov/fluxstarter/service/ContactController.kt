package com.example.khusaenov.fluxstarter.service

import com.example.khusaenov.fluxstarter.model.Contact
import com.example.khusaenov.fluxstarter.repository.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author Khusaenov on 10.08.2018
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/contacts")
class ContactController @Autowired constructor(private val contactRepository: ContactRepository) {

    @GetMapping(produces = arrayOf(APPLICATION_STREAM_JSON_VALUE))
    fun getContacts(): Flux<Contact> = contactRepository.findAll()


    @PostMapping(produces = arrayOf(APPLICATION_STREAM_JSON_VALUE))
    fun saveContact(@RequestBody contact: Contact): Mono<Contact>? {
        return contactRepository.save(contact).log()
    }


    @PutMapping(path = arrayOf("/{id}"), produces = arrayOf(APPLICATION_STREAM_JSON_VALUE))
    fun updateContact(@PathVariable id: String, @RequestBody contact: Contact): Mono<Contact> {
        return contactRepository.save(contact).log()
    }

    @DeleteMapping(path = arrayOf("/{id}"), produces = arrayOf(APPLICATION_STREAM_JSON_VALUE))
    fun deleteContact(@PathVariable contact: Contact): String {
        contactRepository.delete(contact).log()
        return "Success"
    }
}