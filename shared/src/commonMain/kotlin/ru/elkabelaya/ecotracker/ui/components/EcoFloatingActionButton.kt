package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * EcoTracker floating action button.
 *
 * Figma: `EcoTrack / Actions / Floating add`
 * - 56×56, circle, bg primary, green glow shadow, icon 24 dp
 *
 * @param elevated add a colored glow shadow.
 * @param icon the icon to display (default: Add).
 */
@Composable
fun EcoFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Add,
    contentDescription: String? = null,
    elevated: Boolean = true,
) {
    val bg = MaterialTheme.colorScheme.primary
    val iconTint = MaterialTheme.colorScheme.onPrimary

    Box(
        modifier = modifier
            .size(Dimens.Size.xxl)
            .clip(CircleShape)
            .background(bg)
            .let {
                if (elevated) {
                    it.shadow(
                        elevation = Dimens.Elevation.high,
                        shape = CircleShape,
                        ambientColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                        spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
                    )
                } else {
                    it
                }
            }
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = iconTint,
            modifier = Modifier.size(24.dp)
        )
    }
}

@AppPreview
@Composable
private fun EcoFloatingActionButtonPreview() {
    EcoTrackTheme {
        EcoFloatingActionButton({})
    }
}
