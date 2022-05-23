package co.com.esteban.imdbapp.start.root.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.start.auxiliar.composables.AppName
import co.com.esteban.imdbapp.start.auxiliar.composables.LoginAlternativesButton
import co.com.esteban.imdbapp.start.auxiliar.composables.TextFieldWithSeparatedLabel

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
            SignInButton(enabledButton) { /*TODO*/ }
            Text(stringResource(R.string.sign_in_alternative))
            AlternativeSignInButtons()
            AnnotatedTextForSignUp(navigateToSignUpScreen)
            Text(
                stringResource(R.string.continue_as_guest),
                style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold)
            )
        }

    }
}

@Composable
private fun TextFieldsInForm(
    textUserValue: String,
    textPasswordValue: String,
    onUserValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit
) {
    TextFieldWithSeparatedLabel(
        textUserValue,
        stringResource(R.string.user_label),
        modifier = Modifier.padding(bottom = 20.dp),
        onTextFieldValueChange = onUserValueChange
    )
    TextFieldWithSeparatedLabel(
        textPasswordValue,
        stringResource(R.string.password_label),
        modifier = Modifier.padding(bottom = 10.dp),
        onTextFieldValueChange = onPasswordValueChange
    )
}

@Composable
private fun SignInButton(enabledButton: Boolean, onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        modifier = Modifier
            .height(90.dp)
            .padding(top = 30.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary
        ),
        shape = MaterialTheme.shapes.medium,
        enabled = enabledButton
    ) {
        Text(stringResource(R.string.login))
    }
}

@Composable
private fun AlternativeSignInButtons() {
    Row(modifier = Modifier.fillMaxWidth()) {
        LoginAlternativesButton(
            R.drawable.apple_logo,
            stringResource(R.string.content_description_sign_in_alternative_apple)
        ) { /*TODO*/ }
        LoginAlternativesButton(
            R.drawable.facebook_logo,
            stringResource(R.string.content_description_sign_in_alternative_facebook)
        ) { /*TODO*/ }
        LoginAlternativesButton(
            R.drawable.google_logo,
            stringResource(R.string.content_description_sign_in_alternative_google)
        ) { /*TODO*/ }
    }
}

@Composable
private fun AnnotatedTextForSignUp(navigateToSignUpScreen: () -> Unit) {
    val annotatedText = buildAnnotatedString {
        append(stringResource(id = R.string.does_not_have_account))
        pushStringAnnotation(tag = "action", annotation = "sign_up")
        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
            append(stringResource(id = R.string.sign_up))
        }
        pop()
    }

    ClickableText(text = annotatedText,
        modifier = Modifier.padding(bottom = 20.dp, top = 20.dp),
        style = MaterialTheme.typography.caption,
        onClick = {
            annotatedText.getStringAnnotations("action", start = it, end = it)
                .firstOrNull()?.let {
                    navigateToSignUpScreen()
                }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginFormScreenPreview() {
    LoginFormScreen {}
}