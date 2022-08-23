package co.com.esteban.imdbapp.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.home.model.Movie
import co.com.esteban.imdbapp.home.model.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeTopRatedMoviesViewModel(
    private val repository: MovieRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenViewModelStateHolder())
    val state: StateFlow<HomeScreenState> = _state.map {
        it.toUiState()
    }.stateIn(viewModelScope, SharingStarted.Eagerly, _state.value.toUiState())

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            try {
                repository.getTopRated().collect { movieList ->
                    if (movieList.isEmpty()) {
                        throw NoDataException()
                    }
                    _state.update {
                        it.copy(movieList = movieList)
                    }
                }
            } catch (_: NoDataException) {
                setErrors(listOf(R.string.no_data_to_show))
            } catch (_: Exception) {
                setErrors(listOf(R.string.unexpected_error))
            }
        }
    }

    private fun setErrors(errors: List<Int>) {
        _state.update {
            it.copy(errors = errors)
        }
    }

    private data class HomeScreenViewModelStateHolder(
        val movieList: List<Movie> = listOf(),
        val errors: List<Int> = listOf(),
    ) {
        fun toUiState(): HomeScreenState {
            return when {
                movieList.isEmpty() && errors.isNotEmpty() -> {
                    HomeScreenState.HomeScreenError(errors)
                }
                movieList.isEmpty() && errors.isEmpty() -> {
                    HomeScreenState.HomeScreenLoading
                }
                else -> {
                    HomeScreenState.HomeScreenData(movieList)
                }
            }
        }
    }
}
