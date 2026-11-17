package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * A pill-shaped status chip / badge.
 *
 * Figma: `Chip` — 72×23, radius 9999, bg #4CAF50, text white SemiBold 10.
 */
@Composable
fun EcoChip(
    text: String,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        color = contentColor,
        modifier = modifier
            .background(
                color = containerColor,
                shape = RoundedCornerShape(Dimens.Radius.full)
            )
            .padding(horizontal = 16.dp, vertical = 4.dp)
    )
}

@AppPreview
@Composable
private fun EcoChipPreview() {
    EcoTrackTheme {
        Column {
            Row {
                EcoChip("Active")
                Spacer(Modifier.size(8.dp))
                EcoChip("ОК", containerColor = Color(0xFF4CAF50))
                Spacer(Modifier.size(8.dp))
                EcoChip(
                    "Locked",
                    containerColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    contentColor = MaterialTheme.colorScheme.surface
                )
            }
        }
    }
}
