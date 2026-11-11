package ru.elkabelaya.ecotracker.ui.extensions

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun Icon(
    imageVector: ImageVector,
    contentDescription: StringResource?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
) {
    Icon(
        imageVector,
        if (contentDescription != null) stringResource(contentDescription) else null,
        modifier = modifier,
        tint = tint
    )
}
