package co.com.esteban.imdbapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDBAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SplashScreen()
                }
            }
        }
    }
}

@Composable
fun SplashScreen() {
    Box(contentAlignment = Alignment.Center) {
        Text(
            "IMDb",
            modifier = Modifier.background(color = MaterialTheme.colors.primary),
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6P)
@Composable
fun SplashScreenPreview() {
    IMDBAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.primary
        ) {
            SplashScreen()
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_6P, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkPreview() {
    IMDBAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.primary
        ) {
            SplashScreen()
        }
    }
}