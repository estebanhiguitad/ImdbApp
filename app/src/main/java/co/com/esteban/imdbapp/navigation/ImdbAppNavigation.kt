package co.com.esteban.imdbapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.com.esteban.imdbapp.start.root.composables.LoginFormScreen
import co.com.esteban.imdbapp.start.root.composables.SplashScreen

@Composable
fun ImdbAppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable(route = "splash") {
            SplashScreen {
                navController.navigate("login_form")
            }
        }
        composable(route = "login_form") {
            LoginFormScreen{
                navController.navigate("sign_up")
            }
        }
        composable(route = "sign_up"){
            SplashScreen {
                navController.navigate("login_form")
            }
        }
    }
}