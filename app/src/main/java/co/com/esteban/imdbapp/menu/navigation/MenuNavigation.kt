package co.com.esteban.imdbapp.menu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation

@Composable
internal fun MenuNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home_menu") {
        navigation("home_menu/home_menu", route = "home_menu") {
        }
    }
}

private fun NavGraphBuilder.addHomeTopLevel() {
    // Not yet Implemented
}


private fun NavGraphBuilder.addSearchTopLevel() {
    // Not yet Implemented
}

private fun NavGraphBuilder.addPlayTopLevel() {
    // Not yet Implemented
}

private fun NavGraphBuilder.addProfileTopLevel() {
    // Not yet Implemented
}