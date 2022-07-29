package co.com.esteban.imdbapp.menu.navigation

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.com.bootcamp.testcomponents.assertColor
import co.com.esteban.imdbapp.menu.activities.MenuActivity
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class MenuNavigationTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testBottomMenu_hasPrimaryBackgroundColor_success() {
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
        composeRule.onRoot(useUnmergedTree = true).printToLog("bottomNavigation")
        val node = composeRule.onNodeWithTag("bottomNavigation")
        val bitmap = node.captureToImage().asAndroidBitmap()
        val bitmapColor = bitmap.getColor(0, 100)
        val expectedColor = Color(0xFFfbbd36)
        assertColor(bitmapColor, expectedColor)
    }

    @Test
    fun testBottomMenu_has4Items_success() {
        // given
        val expectedChildren = 4
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

        // Then
        composeRule.onNodeWithTag("bottomNavigation")
            .onChildren().assertCountEquals(expectedChildren)

    }
}

