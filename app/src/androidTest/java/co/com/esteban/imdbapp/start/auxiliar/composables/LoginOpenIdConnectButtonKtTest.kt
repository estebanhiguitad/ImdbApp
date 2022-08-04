package co.com.esteban.imdbapp.start.auxiliar.composables

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import co.com.esteban.imdbapp.R
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class LoginOpenIdConnectButtonTest {

    @get:Rule
    val composeRule = createComposeRule()

    private var wasCalled = false

    @Test
    fun loginOpenIdConnectButton_withAction_callIt() {
        composeRule.setContent {
            LoginOpenIdConnectButton(
                drawable = R.drawable.facebook_logo,
                contentDescription = "Facebook"
            ) {
                wasCalled = true
            }
        }
        composeRule.onNodeWithContentDescription("Facebook").assertIsDisplayed().performClick()
        assertTrue(wasCalled)
    }
}