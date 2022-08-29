package co.com.esteban.imdbapp.home.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.com.esteban.imdbapp.home.model.infraestructure.MovieRepositoryImpl

class HomeTopRatedViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeTopRatedMoviesViewModel::class.java)) {
            return HomeTopRatedMoviesViewModel(MovieRepositoryImpl(context)) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}