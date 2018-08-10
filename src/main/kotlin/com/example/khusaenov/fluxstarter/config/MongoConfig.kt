package com.example.khusaenov.fluxstarter.config

import com.example.khusaenov.fluxstarter.repository.ContactRepository
import com.example.khusaenov.fluxstarter.repository.PersonRepository
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

/**
 * @author Khusaenov on 10.08.2018
 */
@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = [(ContactRepository::class), (PersonRepository::class)])
open class MongoConfig : AbstractReactiveMongoConfiguration() {


    override fun reactiveMongoClient(): MongoClient = mongoClient()

    @Bean
    open fun mongoClient(): MongoClient = MongoClients.create()

    override fun getDatabaseName(): String = "person"

    @Bean
    override fun reactiveMongoTemplate(): ReactiveMongoTemplate = ReactiveMongoTemplate(mongoClient(), databaseName)
}