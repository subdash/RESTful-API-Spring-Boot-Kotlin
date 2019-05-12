package com.example.demo.application

import com.example.demo.MovieRepository
import com.example.demo.models.Movie
import org.slf4j.LoggerFactory

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class LoadDatabase {
    private val log = LoggerFactory.getLogger(this::class.java)
    @Bean
    fun initDatabase(repository: MovieRepository) = CommandLineRunner {
        log.info("Preloading ${repository.save(Movie(
                "Lord of the Rings: Fellowship of the Ring", "fantasy", 2001, Movie.Rating.FIVE_STAR)
        )}")
        log.info("Preloading ${repository.save(Movie(
                "Lord of the Rings: The Two Towers", "fantasy", 2002, Movie.Rating.FIVE_STAR)
        )}")
        log.info("Preloading ${repository.save(Movie(
                "Lord of the Rings: Return of the King", "fantasy", 2003, Movie.Rating.FIVE_STAR)
        )}")
        log.info("Preloading ${repository.save(Movie(
                "Star Wars Episode I: The Phantom Menace", "fantasy", 1999, Movie.Rating.THREE_STAR)
        )}")
        log.info("Preloading ${repository.save(Movie(
                "Star Wars Episode II: Attack of the Clones", "fantasy", 2002, Movie.Rating.TWO_STAR)
        )}")
        log.info("Preloading ${repository.save(Movie(
                "Star Wars Episode III: Revenge of the Sith", "fantasy", 2005, Movie.Rating.FOUR_STAR)
        )}")
        log.info("Preloading ${repository.save(Movie(
                "Star Wars Episode IV: A New Hope", "fantasy", 1977, Movie.Rating.FIVE_STAR)
        )}")
        log.info("Preloading ${repository.save(Movie(
                "Star Wars Episode V: The Empire Strikes Back", "fantasy", 1980, Movie.Rating.FIVE_STAR)
        )}")
        log.info("Preloading ${repository.save(Movie(
                "Star Wars Episode VI: Return of the Jedi", "fantasy", 1983, Movie.Rating.FIVE_STAR)
        )}")
    }
}
