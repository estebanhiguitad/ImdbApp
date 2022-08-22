package co.com.esteban.imdbapp.home.model.repository

import co.com.esteban.imdbapp.home.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getTopRated(): Flow<List<Movie>>
}