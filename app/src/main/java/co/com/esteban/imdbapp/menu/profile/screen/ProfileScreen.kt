package co.com.esteban.imdbapp.menu.profile.screen

import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
internal fun ProfileScreen() {
    Text("Profile Screen")
}


@Composable
internal fun UserPreferencesItem() {
    Card(modifier = Modifier
        .size(120.dp)
        .testTag("First Item")) {
        Surface {
            Text("  Calificar y obtener calificaciones")
        }
        Text("Calificaciones")
        Text("0")
    }
}

