package co.com.esteban.imdbapp.start.auxiliar.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R

@Composable
internal fun TextFieldsInForm(
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
internal fun AlternativeSignInButtons() {
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
internal fun AnnotatedTextForSignUp(navigateToSignUpScreen: () -> Unit) {
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