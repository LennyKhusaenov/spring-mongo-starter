package com.example.khusaenov.fluxstarter.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author Khusaenov on 10.08.2018
 */
@Document(collection = "persons")
data class Persons(@Id val id: String, val name: String?, val surname: String?, val age: Int?, val options: List<String>?) {
}