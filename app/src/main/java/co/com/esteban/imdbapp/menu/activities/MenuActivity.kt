package co.com.esteban.imdbapp.menu.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.navigation.compose.rememberNavController
import co.com.esteban.imdbapp.menu.navigation.MenuNavigation

class MenuActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            MenuNavigation(navHostController = navHostController)
        }
    }
}