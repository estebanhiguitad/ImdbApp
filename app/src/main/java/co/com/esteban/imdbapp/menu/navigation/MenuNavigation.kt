@file:OptIn(ExperimentalAnimationApi::class)

package co.com.esteban.imdbapp.menu.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import co.com.esteban.imdbapp.menu.HomeScreen
import co.com.esteban.imdbapp.menu.PlayScreen
import co.com.esteban.imdbapp.menu.ProfileScreen
import co.com.esteban.imdbapp.menu.SearchScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost


internal sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Search : Screen("search")
    object Play : Screen("play")
    object Profile : Screen("profile")
}

private sealed class LeafScreen(val route: String) {
    fun createRoute(screen: Screen) = "${screen.route}/$route"

    object Home : LeafScreen("home")
    object Search : LeafScreen("search")
    object Play : LeafScreen("play")
    object Profile : LeafScreen("profile")
}

@Composable
internal fun MenuNavigation(navHostController: NavHostController, modifier: Modifier) {
    AnimatedNavHost(navController = navHostController, startDestination = Screen.Home.route) {
        addHomeTopLevel()
        addSearchTopLevel()
        addPlayTopLevel()
        addProfileTopLevel()
    }
}

private fun NavGraphBuilder.addHomeTopLevel() {
    navigation(
        startDestination = LeafScreen.Home.createRoute(Screen.Home),
        route = Screen.Home.route
    ) {
        addHome(Screen.Home)
    }
}

private fun NavGraphBuilder.addSearchTopLevel() {
    navigation(
        startDestination = LeafScreen.Search.createRoute(Screen.Search),
        route = Screen.Search.route
    ) {
        addSearch(Screen.Search)
    }
}

private fun NavGraphBuilder.addPlayTopLevel() {
    navigation(
        startDestination = LeafScreen.Play.createRoute(Screen.Play),
        route = Screen.Play.route
    ) {
        addPlay(Screen.Play)
    }
}

private fun NavGraphBuilder.addProfileTopLevel() {
    navigation(
        startDestination = LeafScreen.Profile.createRoute(Screen.Profile),
        route = Screen.Profile.route
    ) {
        addProfile(Screen.Profile)
    }
}

private fun NavGraphBuilder.addHome(root: Screen.Home) {
    composable(route = LeafScreen.Home.createRoute(root)) {
        HomeScreen()
    }
}

private fun NavGraphBuilder.addSearch(root: Screen.Search) {
    composable(route = LeafScreen.Search.createRoute(root)) {
        SearchScreen()
    }
}

private fun NavGraphBuilder.addPlay(root: Screen.Play) {
    composable(route = LeafScreen.Play.createRoute(root)) {
        PlayScreen()
    }
}

private fun NavGraphBuilder.addProfile(root: Screen.Profile) {
    composable(route = LeafScreen.Profile.createRoute(root)) {
        ProfileScreen()
    }
}