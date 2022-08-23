package co.com.esteban.imdbapp.home.viewmodel

import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.home.model.Movie
import co.com.esteban.imdbapp.home.model.MovieBuilder
import co.com.esteban.imdbapp.home.model.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Test

class HomeTopRatedMoviesViewModelTest {

    @ExperimentalCoroutinesApi
    @After
    fun after(){
        Dispatchers.resetMain()
    }

    @ExperimentalCoroutinesApi
    @Test()
    fun getState_fullData_listWithItems() = runTest {
        // Arrange
        val testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)

        val viewModel = HomeTopRatedMoviesViewModel(object : MovieRepository {
            override fun getTopRated(): Flow<List<Movie>> = flow {
                emit(
                    listOf(
                        MovieBuilder().build(),
                        MovieBuilder().withTitle("Second Movie").build()
                    )
                )
            }
        })

        // Act
        val state: HomeScreenState = viewModel.state.value
        assert(state is HomeScreenState.HomeScreenData)
        val movieList = (state as HomeScreenState.HomeScreenData).movieList

        // Assert
        assertNotNull(movieList.findLast { it.title == "Second Movie" } )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getState_repositoryError_errorState() = runTest{
        // Arrange
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)

        val viewModel = HomeTopRatedMoviesViewModel(object : MovieRepository {
            override fun getTopRated(): Flow<List<Movie>> = flow {
                throw Exception("We have an unexpected error")
            }
        })

        // Act
        val state: HomeScreenState = viewModel.state.value
        assert(state is HomeScreenState.HomeScreenError)
        val errors = (state as HomeScreenState.HomeScreenError).errors

        // Assert
        assertNotNull(errors[0] == R.string.unexpected_error )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getState_emptyList_errorState() = runTest{
        // Arrange
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)

        val viewModel = HomeTopRatedMoviesViewModel(object : MovieRepository {
            override fun getTopRated(): Flow<List<Movie>> = flow {
                emit(listOf())
            }
        })

        // Act
        val state: HomeScreenState = viewModel.state.value
        assert(state is HomeScreenState.HomeScreenError)
        val errors = (state as HomeScreenState.HomeScreenError).errors

        // Assert
        assert(errors.size == 1)
        assertNotNull(errors[0] == R.string.no_data_to_show)
    }
}