package co.com.esteban.imdbapp.start.root.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.start.auxiliar.composables.*

@Composable
fun LoginFormScreen(navigateToSignUpScreen: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 56.dp)
        ) {
            var textUserValue by remember { mutableStateOf("") }
            var textPasswordValue by remember { mutableStateOf("") }
            val enabledButton by remember { mutableStateOf(false) }

            AppName(textStyle = MaterialTheme.typography.h3)
            TextFieldsInForm(textUserValue, textPasswordValue,
                { textUserValue = it },
                { textPasswordValue = it }
            )
            Text(
                stringResource(R.string.forgot_your_password),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.caption
            )
            LargeStartButton(enabledButton, { /*TODO*/ }) {
                Text(stringResource(R.string.login))
            }
            Text(
                stringResource(R.string.sign_in_alternative),
                modifier = Modifier.padding(top = 46.dp),
                style = MaterialTheme.typography.caption.copy(color = MaterialTheme.colors.secondary)
            )
            AlternativeSignInButtons()
            AnnotatedTextForSignUp(navigateToSignUpScreen)
            Text(
                stringResource(R.string.continue_as_guest),
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.secondary
                )
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormScreenPreview() {
    LoginFormScreen {}
}