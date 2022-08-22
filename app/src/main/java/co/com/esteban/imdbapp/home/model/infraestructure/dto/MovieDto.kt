package co.com.esteban.imdbapp.home.model.infraestructure.dto

import com.squareup.moshi.Json

data class MovieDto(
    @Json(name = "original_title")
    val title: String,
    @Json(name = "vote_average")
    val rate: Int,
    @Json(name = "poster_path")
    val poster: Int,
    val overview: String
)