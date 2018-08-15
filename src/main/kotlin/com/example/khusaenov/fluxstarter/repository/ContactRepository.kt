package com.example.khusaenov.fluxstarter.repository

import com.example.khusaenov.fluxstarter.model.Contact
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

/**
 * @author Khusaenov on 10.08.2018
 */
interface ContactRepository : ReactiveMongoRepository<Contact, String> {

    fun getContactById(id: String): Mono<Contact>
}