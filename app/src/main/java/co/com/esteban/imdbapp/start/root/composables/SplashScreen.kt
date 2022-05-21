package co.com.esteban.imdbapp.start.root.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import co.com.esteban.imdbapp.start.auxiliar.composables.AppName
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(afterSplashNavigateTo: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        Box(contentAlignment = Alignment.Center) {
            AppName(MaterialTheme.typography.h1)
        }
    }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = "delay") {
        coroutineScope.launch {
            val time: Long = 2000
            delay(time)
            afterSplashNavigateTo()
        }
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
            SplashScreen {}
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
            SplashScreen {}
        }
    }
}