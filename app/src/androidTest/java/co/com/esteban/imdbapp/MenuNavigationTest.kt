package co.com.esteban.imdbapp

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.com.esteban.imdbapp.menu.navigation.MenuNavigationBottom
import co.com.esteban.imdbapp.menu.navigation.Screen
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class MenuNavigationTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testSplash_hasTextForIMDb_Success() {
        // given
        composeRule.setContent {
            IMDBAppTheme {

                // when
                MenuNavigationBottom(
                    selectedItem = Screen.Home,
                    modifier = Modifier.testTag("bottomNavigation"),
                    onNavigationSelected = {}
                )
            }
        }

        // then
        val node = composeRule.onNodeWithTag("bottomNavigation")
        val bitmap = node.captureToImage().asAndroidBitmap()
        val bitmapColor = bitmap.getColor(0, 100)
        val expectedColor = Color(0xFFfbbd36)
        assertColor(bitmapColor, expectedColor)
    }

    //Todo: Create a new test for backgroud color verification
}