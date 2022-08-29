package co.com.esteban.imdbapp.home.model.infraestructure

import android.content.Context
import co.com.esteban.imdbapp.home.model.Movie
import co.com.esteban.imdbapp.home.model.infraestructure.api_services.MovieService
import co.com.esteban.imdbapp.home.model.infraestructure.translate.toMovie
import co.com.esteban.imdbapp.home.model.repository.MovieRepository
import com.chuckerteam.chucker.api.ChuckerInterceptor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieRepositoryImpl(private val context: Context) : MovieRepository {
    override fun getTopRated(): Flow<List<Movie>> = flow {
        val clientHttp = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .build()
        val movieResponse: List<Movie> = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(clientHttp)
            .build()
            .create(MovieService::class.java)
            .topRated().results.map {
                it.toMovie()
            }
        emit(movieResponse)
    }.flowOn(Dispatchers.IO)
}