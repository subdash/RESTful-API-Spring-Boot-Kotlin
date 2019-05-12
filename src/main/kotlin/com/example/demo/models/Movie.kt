package com.example.demo.models

import lombok.Data
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

import javax.validation.constraints.Size

@Data
@Entity
@Table(name = "movie")
class Movie(
        @Valid @NotNull @Size(min = 2, max = 64)      var name: String,
        @Valid @NotNull @Size(min = 3, max = 32)      var genre: String,
        @Valid @NotNull @Size(min = 1800, max = 2020) var yearRelease: Int,
        @Valid @NotNull var rating: Rating
) {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
        set(id) { field = this.id }

    enum class Rating {
        ONE_STAR,
        TWO_STAR,
        THREE_STAR,
        FOUR_STAR,
        FIVE_STAR
    }
    override fun toString() = "Movie[id=$id, name=$name, genre=$genre, yearRelease=$yearRelease, rating=$rating]"
}
