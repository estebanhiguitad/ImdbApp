package co.com.esteban.imdbapp.start.auxiliar.composables

import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LargeStartButtonKtTest {

    @get:Rule
    val composeRule = createComposeRule()
    private var wasCall = false

    @Before
    fun before() {
        composeRule.setContent {
            LargeStartButton(enabledButton = true, onButtonClick = { wasCall = true }) {
                Text("Test", modifier = Modifier.testTag("TextToTest"))
            }
        }
    }

    @Test
    fun largeStartButton_withContent_showContent() {
        composeRule.onNodeWithTag("TextToTest", useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun largeStartButton_withAction_executeAction() {
        composeRule.onRoot().onChild().performClick()
        assertTrue(wasCall)
    }
}