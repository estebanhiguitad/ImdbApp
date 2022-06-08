package co.com.esteban.imdbapp.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.rememberNavController
import co.com.esteban.imdbapp.menu.navigation.MenuNavigation
import co.com.esteban.imdbapp.menu.navigation.MenuNavigationBottom
import co.com.esteban.imdbapp.menu.navigation.Screen

@Composable
internal fun MenuScreen() {
    val navigator = ComposeNavigator()
    val controller = rememberNavController(navigator)
    Scaffold(
        bottomBar = bottomMenuBar(controller),
        content = content(controller)
    )
}

private fun content(controller: NavHostController): @Composable (PaddingValues) -> Unit = {
    Row(modifier = Modifier.padding(it).fillMaxSize()) {
        MenuNavigation(
            navHostController = controller,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
    }
}

private fun bottomMenuBar(navController: NavHostController): @Composable () -> Unit = {
    var selectedItem by remember { mutableStateOf<Screen>(Screen.Home) }

    val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
        when {
            destination.hierarchy.any { it.route == Screen.Home.route } -> {
                selectedItem = Screen.Home
            }
            destination.hierarchy.any { it.route == Screen.Search.route } -> {
                selectedItem = Screen.Search
            }
            destination.hierarchy.any { it.route == Screen.Play.route } -> {
                selectedItem = Screen.Play
            }
            destination.hierarchy.any { it.route == Screen.Profile.route } -> {
                selectedItem = Screen.Profile
            }
        }
    }
    navController.addOnDestinationChangedListener(listener)

    MenuNavigationBottom(selectedItem, Modifier.fillMaxWidth()) {
        navController.navigate(it.route)
    }
}