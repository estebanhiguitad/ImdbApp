package co.com.esteban.imdbapp.start.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import co.com.esteban.imdbapp.menu.activities.MenuActivity
import co.com.esteban.imdbapp.start.root.composables.LoginFormScreen
import co.com.esteban.imdbapp.start.root.composables.SignInScreen
import co.com.esteban.imdbapp.start.root.composables.SplashScreen

@Composable
fun StartNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        navigation("home_screen/home_screen", "home_screen") {
            activity("menu") {
                activityClass = MenuActivity::class
            }
        }

        composable(route = "splash") {
            SplashScreen {
                navController.navigate("login_form")
            }
        }
        composable(route = "login_form") {
            LoginFormScreen(
                {
                    navController.navigate("sign_up")
                },
                {
                    navController.navigate("menu")
                }
            )
        }
        composable(route = "sign_up") {
            SignInScreen({
                navController.navigateUp()
            }, {})
        }
    }
}