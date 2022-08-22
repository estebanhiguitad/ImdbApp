package co.com.esteban.imdbapp.home.model.infraestructure.translate

import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.home.model.Movie
import co.com.esteban.imdbapp.home.model.infraestructure.dto.MovieDto


fun MovieDto.toMovie(): Movie = Movie(
    title, rate.toString(), R.drawable.stranger_things_poster, overview
)