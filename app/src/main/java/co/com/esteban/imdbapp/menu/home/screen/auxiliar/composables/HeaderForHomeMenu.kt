package co.com.esteban.imdbapp.menu.home.screen.auxiliar.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import co.com.esteban.imdbapp.R

@Composable
internal fun HeaderForHomeMenu() {
    ConstraintLayout {
        val constraintLayoutScope = this
        val banner = constraintLayoutScope.createRef()
        val poster = ConstrainedLayoutReference("poster")

        Box(contentAlignment = Alignment.Center, modifier = Modifier.constrainAs(banner) {}) {
            Image(
                painter = painterResource(id = R.drawable.banner_stranger_things),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp),
                contentScale = ContentScale.FillWidth
            )
            Icon(
                imageVector = Icons.Filled.PlayCircle,
                contentDescription = "",
                modifier = Modifier.size(50.dp),
                tint = MaterialTheme.colors.background
            )
        }
        Row(
            modifier = Modifier.constrainAs(poster) {
                top.linkTo(anchor = parent.top, margin = 120.dp)
                start.linkTo(parent.start, margin = 30.dp)
            },
        ) {
            Image(
                painter = painterResource(R.drawable.stranger_things_poster),
                contentDescription = "",
                modifier = Modifier
                    .height(180.dp)
                    .alignBy(LastBaseline)
            )
            Column(
                modifier = Modifier
                    .height(180.dp)
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    stringResource(R.string.home_movie_title),
                    style = MaterialTheme.typography.h5,
                )
                Text(stringResource(R.string.home_movie_caption))
            }

        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6P, showSystemUi = true)
@Composable
fun HeaderForHomeMenuPreview() {
    HeaderForHomeMenu()
}