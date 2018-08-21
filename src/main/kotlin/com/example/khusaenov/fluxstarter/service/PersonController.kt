//package com.example.khusaenov.fluxstarter.service
//
//import com.example.khusaenov.fluxstarter.model.Persons
//import com.example.khusaenov.fluxstarter.repository.PersonRepository
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RestController
//import reactor.core.publisher.Flux
//import java.util.*
//
///**
// * @author Khusaenov on 15.08.2018
// */
//@RestController
//class PersonController @Autowired
//constructor(
//        private val personRepository: PersonRepository) {
//
//    @GetMapping(path = arrayOf("/persons"), produces = arrayOf(org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE))
//    fun getAllPersons(): Flux<Persons> {
//        return personRepository.findAll().log()
//    }
//
//    @GetMapping(path = arrayOf("/person"), produces = arrayOf(org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE))
//    fun getPerson(): Persons {
//        return Persons(UUID.randomUUID().toString(), "Leniz", "Khusaenov", 24, Collections.singletonList(""))
//    }
//}