package co.com.esteban.imdbapp.home.model.infraestructure.dto

import com.squareup.moshi.Json

data class MovieDto(
    val title: String,
    @field:Json(name = "poster_path")
    val posterForMovie: String,
    @field:Json(name = "vote_average")
    val rate: Double,
    val overview: String
)