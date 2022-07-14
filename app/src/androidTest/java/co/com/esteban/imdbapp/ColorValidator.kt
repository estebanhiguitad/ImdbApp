package co.com.esteban.imdbapp

import androidx.compose.ui.graphics.Color


fun assertColor(graphicsColor: android.graphics.Color, expectedColor: Color){
    val color = Color(
        graphicsColor.red(), graphicsColor.green(),
        graphicsColor.blue(), graphicsColor.alpha()
    )
    assert(color.red == expectedColor.red)
    assert(color.blue == expectedColor.blue)
    assert(color.green == expectedColor.green)
    assert(color.alpha == expectedColor.alpha)
}