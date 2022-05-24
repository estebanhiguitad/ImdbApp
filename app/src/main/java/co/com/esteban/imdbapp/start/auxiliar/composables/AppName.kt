package co.com.esteban.imdbapp.start.auxiliar.composables

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import co.com.esteban.imdbapp.R
import co.com.esteban.imdbapp.ui.theme.IMDBAppTheme

@Composable
internal fun AppName(
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        stringResource(R.string.app_name),
        style = textStyle,
        modifier = modifier.background(color = MaterialTheme.colors.primary)
    )
}

@Preview(name = "AppName", showBackground = true)
@Composable
fun AppNamePreview() {
    IMDBAppTheme {
        Surface(
            color = MaterialTheme.colors.primary
        ) {
            AppName(textStyle = MaterialTheme.typography.h3)
        }
    }
}

@Preview(name = "AppName Night", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppNameDarkPreview() {
    IMDBAppTheme {
        Surface(
            color = MaterialTheme.colors.primary
        ) {
            AppName(textStyle = MaterialTheme.typography.h1)
        }
    }
}
