package co.com.esteban.imdbapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.com.esteban.imdbapp.start.root.composables.SplashScreen
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
class SplashScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testSplash_hasTextForIMDb_Success() {
        composeRule.setContent {
            IMDBAppTheme {
                SplashScreen()
            }
        }

        composeRule.onNodeWithText("IMDb").assertIsDisplayed()
    }

    //Todo: Create a new test for backgroud color verification
}