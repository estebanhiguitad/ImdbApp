package co.com.esteban.imdbapp.home.viewmodel

import co.com.esteban.imdbapp.home.model.Movie

sealed interface HomeScreenState {
    data class HomeScreenData(
        val movieList: List<Movie> = listOf(),
    ) : HomeScreenState

    data class HomeScreenError(
        val errors: List<Int> = listOf(),
    ) : HomeScreenState

    object HomeScreenLoading: HomeScreenState
}

