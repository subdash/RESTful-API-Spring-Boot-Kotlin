package com.example.demo.services

import com.example.demo.models.Movie

interface MovieService {
    fun getOneById(id: Long): Movie
    fun getAll(): List<Movie>
    fun createOne(movie: Movie): Movie
    fun updateOne(id: Long, newMovie: Movie): Movie
    fun deleteOne(id: Long)
}