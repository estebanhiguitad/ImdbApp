package co.com.esteban.imdbapp.start.auxiliar.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
internal fun LoginAlternativesButton(
    drawable: Int,
    contentDescription: String,
    onButtonAlternativeAuthenticationClick: () -> Unit
) {
    Button(
        onClick = onButtonAlternativeAuthenticationClick,
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier.background(
                MaterialTheme.colors.background,
                shape = RoundedCornerShape(50.dp)
            )
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = contentDescription,
                modifier = Modifier
                    .padding(16.dp)
                    .size(30.dp)
            )
        }
    }
}