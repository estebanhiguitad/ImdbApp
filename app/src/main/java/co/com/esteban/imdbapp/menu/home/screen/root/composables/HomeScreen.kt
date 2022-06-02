package co.com.esteban.imdbapp.menu.home.screen.root.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.menu.home.screen.auxiliar.composables.HeaderForHomeMenu

@Composable
internal fun HomeScreen() {
    val scrollable = rememberScrollState()
    val movieTopList = buildMovieTopList()
    Column(
        modifier = Modifier
            .verticalScroll(scrollable)
            .padding(bottom = 50.dp)
    ) {
        HeaderForHomeMenu()
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Divider(thickness = 14.dp, modifier = Modifier.paddingFromBaseline(0.dp))
            QuoteText()
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(top = 20.dp, start = 30.dp)
            ) {
                items(movieTopList.size) {
                    val movie = movieTopList[it]
                    Card {
                        Column {
                            Image(
                                painter = painterResource(movie.poster),
                                contentDescription = movie.contentDescription,
                                modifier = Modifier.height(200.dp),
                                contentScale = ContentScale.Inside
                            )
                            Surface(
                                color = MaterialTheme.colors.background,
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Start,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Icon(Icons.Filled.Star, null)
                                        Text("4.5")
                                    }
                                    Text(movie.title)
                                    Row(
                                        Modifier.fillParentMaxWidth(0.3f),
                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        Icon(Icons.Outlined.Info, null)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun buildMovieTopList(): List<Movie> {
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

data class Movie(
    val title: String,
    val rate: String,
    val poster: Int,
    val contentDescription: String
)

@Composable
private fun QuoteText() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 14.dp, start = 30.dp)
    ) {
        Spacer(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colors.primary,
                    MaterialTheme.shapes.medium
                )
                .height(26.dp)
                .width(8.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Las mejores selecciones", style = MaterialTheme.typography.h6)
    }
}

@Preview(showBackground = true)
@Composable
internal fun HomeScreenPreview() {
    HomeScreen()
}