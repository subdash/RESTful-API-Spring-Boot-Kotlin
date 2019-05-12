package com.example.demo.controllers

import com.example.demo.MovieRepository
import com.example.demo.MovieResourceAssembler
import com.example.demo.models.Movie
import com.example.demo.services.MovieService
import org.springframework.hateoas.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import java.lang.RuntimeException
import org.springframework.hateoas.Resources
import java.net.URI
import java.util.stream.Collectors

@RestController
@RequestMapping("/api")
class MovieController(
        private val repository: MovieRepository,
        private val assembler: MovieResourceAssembler,
        private val movieService: MovieService
) {
    @GetMapping("/movies/{id}")
    fun one(@PathVariable id: Long) = this.assembler.toResource(this.movieService.getOneById(id))

    @GetMapping("/movies")
    fun all(): Resources<Resource<Movie>> = this.movieService.getAll()
            .stream()
            .map(assembler::toResource)
            .collect(Collectors.toList()).let {
                return Resources(it, linkTo(methodOn(this::class.java).all()).withSelfRel())
            }

    @PostMapping("/movies")
    fun create(@RequestBody newMovie: Movie) = this.assembler.toResource(this.movieService.createOne(newMovie)).let {
        ResponseEntity.created(URI(it.id.expand().href)).body(it)
    }

    @PutMapping("/movies/{id}")
    fun update(@PathVariable id: Long, @RequestBody newMovie: Movie) = this.assembler.toResource(
            this.movieService.updateOne(id, newMovie)
    )

    @DeleteMapping("/movies/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<*> = when {
        this.repository.findById(id).isPresent -> {
            this.movieService.deleteOne(id)
            ResponseEntity.noContent().build<Any>()
        }
        else -> ResponseEntity.notFound().build<Any>()
    }
}

class MovieNotFoundException(id: Long) : RuntimeException("Movie $id could not be found")

@ControllerAdvice
class MovieNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MovieNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun movieNotFoundHandler(e: MovieNotFoundException) = e.message
}
