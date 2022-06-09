package co.com.esteban.imdbapp.menu.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import co.com.esteban.imdbapp.menu.MenuScreen
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDBAppTheme(isSystemInDarkTheme()) {
                MenuScreen()
            }
        }
    }
}