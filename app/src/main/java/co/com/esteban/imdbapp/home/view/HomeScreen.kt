package co.com.esteban.imdbapp.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.home.viewmodel.HomeScreenState
import co.com.esteban.imdbapp.home.viewmodel.HomeTopRatedMoviesViewModel
import co.com.esteban.imdbapp.home.viewmodel.HomeTopRatedViewModelFactory

@Composable
internal fun HomeScreen(
    viewModel: HomeTopRatedMoviesViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = HomeTopRatedViewModelFactory()
    )
) {
    val scrollable = rememberScrollState()
    val state by viewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollable)
            .padding(bottom = 20.dp)
    ) {
        HeaderForHomeMenu()

        when (val finalState = state) {
            is HomeScreenState.HomeScreenData ->
                PanelMovieList(finalState.movieList)
            is HomeScreenState.HomeScreenError ->
                Text(stringResource(finalState.errors.first()))
            is HomeScreenState.HomeScreenLoading ->
                CircularProgressIndicator()
        }

    }
}

@Preview(showBackground = true)
@Composable
internal fun HomeScreenPreview() {
    HomeScreen()
}