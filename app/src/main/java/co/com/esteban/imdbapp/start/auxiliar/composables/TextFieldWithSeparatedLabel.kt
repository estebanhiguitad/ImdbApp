package co.com.esteban.imdbapp.start.auxiliar.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun TextFieldWithSeparatedLabel(
    textValue: String,
    labelValue: String,
    modifier: Modifier = Modifier,
    onTextFieldValueChange: (String) -> Unit,
    inputContentDescription: String
) {
    Text(
        labelValue,
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
        color = MaterialTheme.colors.secondary
    )
    TextField(
        modifier = modifier.fillMaxWidth().semantics {
            this.contentDescription = inputContentDescription
        },
        value = textValue,
        onValueChange = onTextFieldValueChange,
        shape = MaterialTheme.shapes.medium,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            textColor = Color.Black
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldWithSeparatedLabelPreview() {
    Surface(color = MaterialTheme.colors.primary) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {
            TextFieldWithSeparatedLabel(
                textValue = "",
                labelValue = "Usuario",
                onTextFieldValueChange = {},
                inputContentDescription = "Input Content Description"
            )
        }
    }
}