package ru.elkabelaya.ecotracker.ui.extensions

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun Text(
    resource: StringResource,
    modifier: Modifier = Modifier,
    style: TextStyle,
) {
    Text(
        text = stringResource(resource),
        modifier = modifier,
        style = style,
    )
}
