package co.com.esteban.imdbapp.start.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.rememberNavController
import co.com.esteban.imdbapp.navigation.StartNavigation
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme

@ExperimentalAnimationApi
class ImdbAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDBAppTheme {
                val navController = rememberNavController()
                StartNavigation(navController)
            }
        }
    }

}
