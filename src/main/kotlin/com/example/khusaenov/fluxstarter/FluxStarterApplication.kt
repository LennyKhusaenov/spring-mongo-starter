package com.example.khusaenov.fluxstarter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class FluxStarterApplication

fun main(args: Array<String>) {
    runApplication<FluxStarterApplication>(*args)
}
