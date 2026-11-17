package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * EcoTracker toggle switch.
 *
 * Figma: `EcoTrack / Controls / Switch`
 * - 44×24, pill shape, thumb 16×16 circle
 * - Light Off: track surfaceVariant, thumb surface
 * - Light On:  track primary, thumb onPrimary (white)
 * - Dark  Off: track surfaceVariant, thumb surface
 * - Dark  On:  track primary, thumb onPrimary
 */
@Composable
fun EcoSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val trackColor = if (checked) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }

    val thumbColor = MaterialTheme.colorScheme.surface

    val thumbAlignment = if (checked) Alignment.CenterEnd else Alignment.CenterStart

    Box(
        modifier = modifier
            .size(width = 44.dp, height = Dimens.Height.switch)
            .background(trackColor, RoundedCornerShape(Dimens.Radius.full))
            .then(
                if (enabled) {
                    Modifier.clickable { onCheckedChange(!checked) }
                } else {
                    Modifier
                }
            ),
    ) {
        Box(
            modifier = Modifier
                .align(thumbAlignment)
                .padding(Dimens.Paddings.xs)
                .size(Dimens.Misc.switchThumb)
                .background(thumbColor, CircleShape)
                .shadow(elevation = Dimens.Elevation.low, shape = CircleShape)
        )
    }
}

@AppPreview
@Composable
private fun EcoSwitchPreview() {
    EcoTrackTheme {
        Column {
            Row {
                EcoSwitch(checked = false, onCheckedChange = {})
                Spacer(Modifier.size(16.dp))
                EcoSwitch(checked = true, onCheckedChange = {})
            }
        }
    }
}
