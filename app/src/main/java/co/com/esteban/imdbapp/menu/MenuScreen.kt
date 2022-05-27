package co.com.esteban.imdbapp.menu

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import co.com.esteban.imdbapp.menu.navigation.MenuNavigation
import co.com.esteban.imdbapp.menu.navigation.MenuNavigationBottom
import co.com.esteban.imdbapp.menu.navigation.Screen
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Composable
internal fun MenuScreen() {
    val navigator = ComposeNavigator()
    val controller = rememberAnimatedNavController(navigator)
    Scaffold(
        bottomBar = bottomMenuBar(controller),
        content = content(controller)
    )
}

private fun content(controller: NavHostController): @Composable (PaddingValues) -> Unit = {
    Row(modifier = Modifier.fillMaxSize()){
        MenuNavigation(navHostController = controller, modifier = Modifier.fillMaxHeight())
    }
}

private fun bottomMenuBar(navController: NavHostController): @Composable () -> Unit = {
    var selectedItem by remember { mutableStateOf<Screen>(Screen.Home) }

    // Todo: Do this listener stable for compose
    navController.addOnDestinationChangedListener { _, destination, _ ->
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

    MenuNavigationBottom(selectedItem, Modifier.fillMaxWidth()) {
        navController.navigate(selectedItem.route){
            launchSingleTop = true
            restoreState = true

            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
        }
    }
}