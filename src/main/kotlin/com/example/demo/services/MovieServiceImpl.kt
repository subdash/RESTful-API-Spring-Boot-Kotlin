package com.example.demo.services

import com.example.demo.models.Movie
import com.example.demo.controllers.MovieNotFoundException
import com.example.demo.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl : MovieService {
    @Autowired
    private lateinit var repository: MovieRepository

    override fun getOneById(id: Long): Movie = this.repository.findById(id).orElseThrow { MovieNotFoundException(id) }

    override fun getAll(): List<Movie> = this.repository.findAll()

    override fun createOne(movie: Movie): Movie = this.repository.save(movie)

    override fun updateOne(id: Long, newMovie: Movie): Movie =
            this.repository.findById(id).map { movie ->
                movie.name = newMovie.name
                movie.genre = newMovie.genre
                movie.yearRelease = newMovie.yearRelease
                movie.rating = newMovie.rating
                this.repository.save(movie)
            }.orElseGet {
                newMovie.id = id
                this.repository.save(newMovie)
            }

    override fun deleteOne(id: Long) = this.repository.deleteById(id)
}