package co.com.esteban.imdbapp.menu.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.rememberNavController
import co.com.esteban.imdbapp.menu.MenuScreen
import co.com.esteban.imdbapp.menu.navigation.MenuNavigation

@ExperimentalAnimationApi
class MenuActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            MenuScreen()
        }
    }
}