package co.com.esteban.imdbapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.menu.UserPreferencesItem
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProfileTest {
    @get:Rule
    val composeRule: ComposeContentTestRule = createComposeRule()

    @Test
    fun userProfile_preferences_itemIsDisplayed() {
        composeRule.setContent {
            IMDBAppTheme {
                UserPreferencesItem()
            }
        }

        composeRule.onRoot().onChild()
            .assertIsDisplayed()
    }

    @Test
    fun userProfile_preferences_aspectRatio() {
        composeRule.setContent {
            IMDBAppTheme {
                UserPreferencesItem()
            }
        }
        composeRule.onNodeWithTag("First Item")
            .assertHeightIsEqualTo(120.dp)
            .assertWidthIsEqualTo(120.dp)
    }

    @Test
    fun userProfile_preferences_threeNodes() {
        composeRule.setContent {
            IMDBAppTheme {
                UserPreferencesItem()
            }
        }

        composeRule.onNode(hasAnyChild(hasTestTag("First Item")))
            .onChildren()
            .assertCountEquals(3)
    }
}