package co.com.esteban.imdbapp.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.home.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeTopRatedMoviesViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenViewModelState())
    val state = _state.map {
        it.toUiState()
    }.stateIn(viewModelScope, SharingStarted.Eagerly, _state.value.toUiState())

    init {
        getMovies()
    }

    private fun getMovies(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
        viewModelScope.launch(dispatcher) {
            delay(3000)
            try {
                val title = "Stranger Things"
                val rate = "4.3"
                val poster = R.drawable.stranger_things_poster
                val movies = listOf(
                    Movie(title, rate, poster, ""),
                    Movie(title, rate, poster, ""),
                    Movie(title, rate, poster, ""),
                    Movie(title, rate, poster, "")
                )
                _state.update {
                    it.copy(movieList = movies)
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(errors = listOf(e.message.toString()))
                }
            }
        }
    }

    private data class HomeScreenViewModelState(
        val movieList: List<Movie> = listOf(),
        val errors: List<String> = listOf(),
    ) {
        fun toUiState(): HomeScreenState {
            return when {
                movieList.isEmpty() && errors.isNotEmpty() -> {
                    HomeScreenState.HomeScreenError(errors)
                }
                movieList.isEmpty() && errors.isEmpty() -> {
                    HomeScreenState.HomeScreenLoading()
                }
                else -> {
                    HomeScreenState.HomeScreenData(movieList)
                }
            }
        }
    }
}
