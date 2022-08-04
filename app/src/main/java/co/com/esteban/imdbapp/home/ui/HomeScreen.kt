package co.com.esteban.imdbapp.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.home.models.Movie

@Composable
internal fun HomeScreen() {
    val scrollable = rememberScrollState()
    val movieTopList = buildMovieTopList()
    Column(
        modifier = Modifier
            .verticalScroll(scrollable)
            .padding(bottom = 20.dp)
    ) {
        HeaderForHomeMenu()
        PanelMovieList(movieTopList)
    }
}

private fun buildMovieTopList(): List<Movie> {
    val title = "Stranger Things"
    val rate = "4.3"
    val poster = R.drawable.stranger_things_poster
    return listOf(
        Movie(title, rate, poster, ""),
        Movie(title, rate, poster, ""),
        Movie(title, rate, poster, ""),
        Movie(title, rate, poster, "")
    )
}

@Preview(showBackground = true)
@Composable
internal fun HomeScreenPreview() {
    HomeScreen()
}