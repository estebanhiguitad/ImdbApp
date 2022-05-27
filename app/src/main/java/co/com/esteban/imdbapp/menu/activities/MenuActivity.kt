package co.com.esteban.imdbapp.menu.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import co.com.esteban.imdbapp.menu.MenuScreen

@ExperimentalAnimationApi
class MenuActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            MenuScreen()
        }
    }
}