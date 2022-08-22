package co.com.esteban.imdbapp.home.model.infraestructure

import co.com.esteban.imdbapp.home.model.Movie
import co.com.esteban.imdbapp.home.model.infraestructure.api_services.MovieService
import co.com.esteban.imdbapp.home.model.infraestructure.translate.toMovie
import co.com.esteban.imdbapp.home.model.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieRepositoryImpl : MovieRepository {
    override fun getTopRated(): Flow<List<Movie>> = flow {
        val movieResponse: List<Movie> = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MovieService::class.java)
            .topRated().results.map {
                it.toMovie()
            }
        emit(movieResponse)
    }.flowOn(Dispatchers.IO)
}