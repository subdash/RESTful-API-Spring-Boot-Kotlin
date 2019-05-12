package com.example.demo

import com.example.demo.models.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : JpaRepository<Movie, Long> {
    fun findByName(name: String): Movie
}
