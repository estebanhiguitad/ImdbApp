package co.com.esteban.imdbapp.home.viewmodel

import co.com.esteban.imdbapp.home.model.Movie

sealed interface HomeScreenState {
    val hasErrors: Boolean
    val showLoader: Boolean

    data class HomeScreenData(
        val movieList: List<Movie> = listOf(),
        override val hasErrors: Boolean = false,
    ) : HomeScreenState {
        override val showLoader: Boolean
            get() = movieList.isEmpty() && !hasErrors
    }

    data class HomeScreenError(
        val errors: List<String> = listOf(),
        override val hasErrors: Boolean = true,
        override val showLoader: Boolean = false,
    ) : HomeScreenState

    data class HomeScreenLoading(
        override val hasErrors: Boolean = false,
        override val showLoader: Boolean = true,
    ) : HomeScreenState
}

