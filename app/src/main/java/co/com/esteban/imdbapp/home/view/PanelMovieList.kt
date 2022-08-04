package co.com.esteban.imdbapp.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.home.model.Movie

@Composable
fun PanelMovieList(movieTopList: List<Movie>) {
    Column(modifier = Modifier.padding(top = 20.dp)) {
        Divider(
            thickness = 14.dp,
            modifier = Modifier.paddingFromBaseline(0.dp),
            color = MaterialTheme.colors.onSurface
        )
        QuoteText()
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(top = 20.dp, start = 30.dp)
        ) {
            items(movieTopList.size) {
                val movie = movieTopList[it]
                val modifier = Modifier.fillParentMaxWidth(0.3f)
                CardVerticalMovie(movie, modifier)
            }
        }
    }
}

@Composable
private fun CardVerticalMovie(
    movie: Movie,
    modifier: Modifier
) {
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
                        modifier = modifier,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(Icons.Outlined.Info, null)
                    }
                }
            }
        }
    }
}

@Composable
private fun QuoteText() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 14.dp, start = 30.dp)
    ) {
        Surface {
            Spacer(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.primary,
                        MaterialTheme.shapes.medium
                    )
                    .height(26.dp)
                    .width(8.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(R.string.best_selections_title),
            style = MaterialTheme.typography.h6
        )
    }
}

@Preview
@Composable
fun QuoteTextPreview() {
    QuoteText()
}