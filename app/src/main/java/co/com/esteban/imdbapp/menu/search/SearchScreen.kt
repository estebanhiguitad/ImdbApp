package co.com.esteban.imdbapp.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun SearchScreen(){
    Column {
        Surface(modifier = Modifier.height(100.dp)) {

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
