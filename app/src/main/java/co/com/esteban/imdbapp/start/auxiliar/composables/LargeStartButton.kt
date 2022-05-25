package co.com.esteban.imdbapp.start.auxiliar.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun LargeStartButton(
    enabledButton: Boolean,
    onButtonClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onButtonClick,
        modifier = Modifier
            .height(90.dp)
            .padding(top = 30.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor =  MaterialTheme.colors.onSecondary
        ),
        shape = MaterialTheme.shapes.medium,
        enabled = enabledButton,
        content = content
    )
}