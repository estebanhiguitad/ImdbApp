package co.com.esteban.imdbapp.home.model.infraestructure.api_services

import co.com.esteban.imdbapp.home.model.infraestructure.dto.TopRatedResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("3/movie/top_rated")
    suspend fun topRated(@Query("api_key") apiKey: String = "c5c47722a4adcc77f6e84f28a48b857a"): TopRatedResponse
}