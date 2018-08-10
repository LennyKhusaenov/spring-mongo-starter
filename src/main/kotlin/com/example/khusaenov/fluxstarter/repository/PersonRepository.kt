package com.example.khusaenov.fluxstarter.repository

import com.example.khusaenov.fluxstarter.model.Persons
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

/**
 * @author Khusaenov on 10.08.2018
 */
interface PersonRepository : ReactiveMongoRepository<Persons, String> {

    fun findPersonByName(): Flux<Persons>

    override fun findAll(): Flux<Persons>

    fun findByAge(): Flux<Persons>
}