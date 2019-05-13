package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
/* When the main method above is run:
 * - Spring Boot will run ALL CommandLineRunner beans once the application context is loaded
 * - This runner will request a copy of the Repository classes
 * - Using them, it will create entities and store them
 */