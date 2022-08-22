package co.com.esteban.imdbapp.home.model.infraestructure

import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.home.model.Movie
import co.com.esteban.imdbapp.home.model.repository.MovieRepository
import com.squareup.moshi.Json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MovieRepositoryImpl : MovieRepository {
    override fun getTopRated(): Flow<List<Movie>> = flow {

        var movieResponse: List<Movie>? = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MovieService::class.java)
            .topRated().results.map {
                it.toMovie()
            }
        movieResponse?.let { emit(it) }
    }.flowOn(Dispatchers.IO)
}

interface MovieService {
    @GET("3/movie/top_rated")
    suspend fun topRated(@Query("api_key") apiKey: String = "c5c47722a4adcc77f6e84f28a48b857a"): TopRatedResponse
}

data class TopRatedResponse(var results: List<MovieDto>)
data class MovieDto(
    @Json(name = "original_title")
    val title: String,
    @Json(name = "vote_average")
    val rate: Int,
    @Json(name = "poster_path")
    val poster: Int,
    val overview: String
)

fun MovieDto.toMovie(): Movie = Movie(
    title, rate.toString(), R.drawable.stranger_things_poster, overview
)