package com.example.demo

import com.example.demo.controllers.MovieController
import com.example.demo.models.Movie
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceAssembler
import org.springframework.hateoas.mvc.ControllerLinkBuilder.*
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class MovieResourceAssembler : ResourceAssembler<Movie, Resource<Movie>> {
    override fun toResource(entity: Movie): Resource<Movie> =
            Resource(entity,
                    linkTo(methodOn(MovieController::class.java)
                            .one(entity.id ?: throw RuntimeException("id is null")))
                            .withSelfRel(),
                    linkTo(methodOn(MovieController::class.java)
                            .all())
                            .withRel("movies")
            )
}