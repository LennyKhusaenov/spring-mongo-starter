package com.example.khusaenov.fluxstarter.service;


import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.created;

import com.example.khusaenov.fluxstarter.model.Contact;
import com.example.khusaenov.fluxstarter.repository.ContactRepository;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Khusaenov on 17.08.2018
 */
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(
            ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Mono<ServerResponse> getAllContacts(ServerRequest serverRequest) {
        Flux<Contact> allContacts = contactRepository.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(allContacts, Contact.class);
    }

    public Mono<ServerResponse> getContactById(ServerRequest serverRequest) {
        Mono<Contact> contactById = contactRepository
                .findById(serverRequest.queryParam("id").orElseThrow(NoSuchElementException::new));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(contactById, Contact.class);
    }

    public Mono<ServerResponse> createNewContact(ServerRequest serverRequest) {
        Mono<Contact> newContact = serverRequest.bodyToMono(Contact.class);
        UUID id = UUID.randomUUID();
        return created(UriComponentsBuilder.fromPath("contacts/" + id).build().toUri())
                .contentType(APPLICATION_JSON)
                .body(
                        fromPublisher(
                                newContact.map(p -> new Contact(p, id))
                                        .flatMap(contactRepository::save), Contact.class)).log();
    }

}
