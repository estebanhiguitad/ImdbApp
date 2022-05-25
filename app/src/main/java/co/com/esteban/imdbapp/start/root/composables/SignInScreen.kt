package co.com.esteban.imdbapp.start.root.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.start.auxiliar.composables.AppName
import co.com.esteban.imdbapp.start.auxiliar.composables.LargeStartButton

@Composable
internal fun SignInScreen(onBackPressed: () -> Unit, onAcceptButton: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(elevation = 0.dp, backgroundColor = MaterialTheme.colors.background) {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.go_back_description)
                    )
                }

            }
        },
        content = {
            var valueForName by remember { mutableStateOf("") }
            var valueForEmail by remember { mutableStateOf("") }
            var valueForPassword by remember { mutableStateOf("") }
            var showPassword by remember { mutableStateOf(false) }
            var enableButton by remember { mutableStateOf(false) }
            val listState = rememberScrollState()

            val nameHint = stringResource(R.string.name_hint)
            val emailHint = stringResource(R.string.email_hint)
            val passwordHint = stringResource(R.string.password_label)


            val choseEnableButton = {
                val validFields = mutableListOf(
                    valueForName.isNotEmpty(),
                    valueForEmail.isNotEmpty(),
                    valueForPassword.length > 7
                )
                enableButton = !validFields.contains(false)
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .verticalScroll(listState)
            ) {
                Column {
                    ImdbTitle()
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CreateAccountTittle()
                    TextFieldFor(nameHint, valueForName, {
                        valueForName = it
                        choseEnableButton()
                    })
                    TextFieldFor(emailHint, valueForEmail, {
                        valueForEmail = it
                        choseEnableButton()
                    })
                    TextFieldFor(
                        passwordHint,
                        valueForPassword,
                        onValueChange = {
                            valueForPassword = it
                            choseEnableButton()
                        },
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        {
                            val modifier = Modifier.clickable {
                                showPassword = !showPassword
                            }

                            Icon(
                                if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = null,
                                modifier = modifier
                            )
                        }
                    )
                    Text(
                        stringResource(R.string.password_lenght),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )

                    LargeStartButton(enabledButton = enableButton, onAcceptButton) {
                        Text(stringResource(R.string.accept))
                    }
                }
            }
        }
    )
}

@Composable
fun ImdbTitle() {
    AppName(
        textStyle = MaterialTheme.typography.h3,
        modifier = Modifier
            .background(MaterialTheme.colors.primary, MaterialTheme.shapes.medium)
            .padding(horizontal = 12.dp, vertical = 0.dp)
    )
}

@Composable
fun CreateAccountTittle() {
    Text(
        text = stringResource(R.string.create_an_account),
        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 46.dp, bottom = 10.dp),
        textAlign = TextAlign.Start
    )
}

@Composable
fun TextFieldFor(
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = hint)
        },
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation
    )
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen({},{})
}