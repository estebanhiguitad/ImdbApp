package co.com.esteban.imdbapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = PrimaryDark,
    primaryVariant = PrimaryVariantDark,
    secondary = Secondary,
    onSecondary = OnSecondary,
    onSurface = OnSurface,
    onBackground = OnBackground
)

private val LightColorPalette = lightColors(
    primary = PrimaryLight,
    primaryVariant = PrimaryVariantLight,
    secondary = Secondary,
    onSecondary = OnSecondary,
    onSurface = OnSurface,
    onBackground = OnBackground
)

@Composable
fun IMDBAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val systemController = rememberSystemUiController()

    SideEffect {
        systemController.setStatusBarColor(colors.primary)
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}