package co.com.esteban.imdbapp.menu.navigation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R

private data class HomeNavigationItem(
    val imageVector: ImageVector,
    val contentDescription: Int,
    val screen: Screen
)

private val NavigationItems = listOf(
    HomeNavigationItem(Icons.Filled.House, R.string.home_menu_content_description, Screen.Home),
    HomeNavigationItem(
        Icons.Filled.Search,
        R.string.search_menu_content_description,
        Screen.Search
    ),
    HomeNavigationItem(
        Icons.Filled.PlayCircle,
        R.string.play_menu_content_description,
        Screen.Play
    ),
    HomeNavigationItem(
        Icons.Filled.AccountCircle,
        R.string.profile_menu_content_description,
        Screen.Profile
    ),
)


@Composable
internal fun MenuNavigationBottom(
    selectedItem: Screen,
    modifier: Modifier,
    onNavigationSelected: (Screen) -> Unit
) {
    BottomNavigation(
        modifier = modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
    ) {
        NavigationItems.forEach {
            BottomNavigationItem(
                selected = selectedItem == it.screen,
                onClick = { onNavigationSelected(it.screen) },
                icon = {
                    Icon(
                        imageVector = it.imageVector,
                        contentDescription = stringResource(it.contentDescription)
                    )
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuNavigationRailPreview() {
    MenuNavigationBottom(selectedItem = Screen.Home, modifier = Modifier) {}
}