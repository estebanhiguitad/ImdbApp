package co.com.esteban.imdbapp.home.view

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertHeightIsEqualTo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertWidthIsEqualTo
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onParent
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.onSiblings
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.assertColor
import co.com.esteban.imdbapp.home.model.MovieBuilder
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme
import org.junit.Rule
import org.junit.Test

class PanelMovieListTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testColumnIsDisplayed() {
        composeRule.setContent {
            PanelMovieList(movieTopList = listOf())
        }

        composeRule.onRoot().assertExists()
    }

    @Test
    fun testTitleBestSelectionsIsDisplayed() {
        var titleForNode = ""
        composeRule.setContent {
            titleForNode = stringResource(id = R.string.best_selections_title)
            PanelMovieList(movieTopList = listOf())
        }

        composeRule.onNodeWithText(titleForNode).assertIsDisplayed()
    }

    @Test
    fun testQuoteHasSize() {
        composeRule.setContent {
            PanelMovieList(movieTopList = listOf())
        }

        composeRule.onRoot().onChildAt(0).assertWidthIsEqualTo(8.dp)
        composeRule.onRoot().onChildAt(0).assertHeightIsEqualTo(26.dp)
    }

    @Test
    fun testQuoteBackgroundColorIsPrimaryColor() {
        composeRule.setContent {
            IMDBAppTheme {
                PanelMovieList(movieTopList = listOf())
            }
        }

        val capture = composeRule.onRoot().onChildAt(0).captureToImage().asAndroidBitmap()
        assertColor(capture.getColor(10, 10), Color(0xFFfbbd36))
    }

    @Test
    fun testListSizeIs3() {
        composeRule.setContent {
            IMDBAppTheme {
                PanelMovieList(
                    movieTopList = listOf(
                        MovieBuilder().build(),
                        MovieBuilder().withTitle("Dark").build(),
                        MovieBuilder().withTitle("Ozark").build()
                    )
                )
            }
        }

        composeRule.onNode(hasText("Dark")).onParent()
            .onParent().onSiblings().assertCountEquals(2)
    }
}