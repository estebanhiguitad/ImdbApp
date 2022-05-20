package co.com.esteban.imdbapp.start.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import co.com.esteban.imdbapp.navigation.ImdbAppNavigation
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme

class ImdbAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDBAppTheme {
                val navController = rememberNavController()
                ImdbAppNavigation(navController)
            }
        }
    }

}
