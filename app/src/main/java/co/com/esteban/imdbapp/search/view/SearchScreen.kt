package co.com.esteban.imdbapp.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R

@Composable
internal fun SearchScreen() {
    Column {
        var searchValue by remember { mutableStateOf("") }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            color = MaterialTheme.colors.surface
        ) {
            TextField(
                value = searchValue,
                onValueChange = {
                    searchValue = it
                },
                leadingIcon = { Icon(Icons.Outlined.Search, "") },
                shape = MaterialTheme.shapes.small,
                placeholder = {Text(stringResource(R.string.search_in_imdb))},
                colors = TextFieldDefaults.textFieldColors(
                    focusedLabelColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    leadingIconColor = MaterialTheme.colors.onBackground,
                    cursorColor = MaterialTheme.colors.onBackground,
                    textColor = MaterialTheme.colors.onBackground,
                    placeholderColor = MaterialTheme.colors.onBackground,
                    backgroundColor = MaterialTheme.colors.onSurface
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 20.dp)
            )

        }
        Surface(color = MaterialTheme.colors.onSurface, modifier = Modifier.fillMaxSize()) {

        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}
