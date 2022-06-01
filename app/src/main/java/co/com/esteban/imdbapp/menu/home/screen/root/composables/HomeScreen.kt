package co.com.esteban.imdbapp.menu.home.screen.root.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import co.com.esteban.imdbapp.menu.home.screen.auxiliar.composables.HeaderForHomeMenu

@Composable
internal fun HomeScreen() {
    HeaderForHomeMenu()
}

@Preview(showBackground = true, device = Devices.NEXUS_6P, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}