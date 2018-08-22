package com.example.khusaenov.fluxstarter.model

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

/**
 * @author Khusaenov on 10.08.2018
 */
@Document(collection = "contacts")
data class Contact(val id: String?,
                   val name: String?,
                   val address: String?,
                   val city: String?,
                   val phone: String?,
                   val email: String?) {
    constructor(contact: Contact, id: UUID) : this(id.toString(), contact.name, contact.address, contact.city, contact.phone, contact.email)
}