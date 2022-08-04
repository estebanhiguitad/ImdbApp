package co.com.esteban.imdbapp.start.auxiliar.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class AppNameKtTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun appName() {
        composeRule.setContent {
            AppName(textStyle = MaterialTheme.typography.h3, modifier = Modifier.testTag("AppName"))
        }

        composeRule.onNodeWithTag("AppName").assertIsDisplayed()
    }
}