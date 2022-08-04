package co.com.esteban.imdbapp.menu.home.ui

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import co.com.esteban.imdbapp.R
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class HeaderForHomeMenuKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun headerForHomeMenu_posterAndTitle_areAlign() {
        composeRule.setContent {
            HeaderForHomeMenu()
        }

        val posterNode = composeRule.onRoot().onChild().onChildAt(2).getBoundsInRoot()
        val descriptionNode = composeRule.onRoot().onChild().onChildAt(4).getBoundsInRoot()
        assertEquals(posterNode.bottom, descriptionNode.bottom)
    }

    @Test
    fun headerForHomeMenu_playIcon_isOnTopOfBanner() {
        var contentDescription  = ""

        composeRule.setContent {
            HeaderForHomeMenu()
            contentDescription = stringResource(id = R.string.content_description_play_or_stop)
        }

        composeRule.onNodeWithContentDescription(contentDescription).assertIsDisplayed()
    }
}