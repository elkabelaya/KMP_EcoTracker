package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.preview.Habit
import ru.elkabelaya.ecotracker.ui.preview.Preview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * Habit card — the primary list item for habits.
 *
 * Figma: `EcoTrack / Cards / Habit`
 * - 346×64, bg surface, radius 16 dp, subtle shadow
 * - Left: category icon 40×40
 * - Center: title (Body 14 Medium) + category label (Body 12 Regular, onSurfaceVariant)
 * - Right: toggle switch or chevron
 *
 * @param habit the domain model to display.
 * @param onClick called when the card is tapped.
 * @param showToggle if true shows an [EcoSwitch] on the right; otherwise a chevron.
 */
@Composable
fun EcoHabitCard(
    habit: Habit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    showToggle: Boolean = true,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.Radius.xl))
            .background(MaterialTheme.colorScheme.surface)
            .shadow(
                elevation = Dimens.Elevation.low,
                shape = RoundedCornerShape(Dimens.Radius.xl)
            )
            .clickable { onClick() }
            .padding(Dimens.Paddings.m),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Category icon
            EcoCategoryIcon(
                category = habit.category,
                size = Dimens.Size.l,
            )

            Spacer(Modifier.width(Dimens.Paddings.m))

            // Text content
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = habit.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(Modifier.size(2.dp))
                Text(
                    text = habit.category.name,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }

            // Right side: toggle or chevron
            if (showToggle) {
                EcoSwitch(
                    checked = habit.isCompleted,
                    onCheckedChange = {},
                )
            } else {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@AppPreview
@Composable
private fun EcoHabitCardPreview() {
    EcoTrackTheme {
        EcoHabitCard(Preview.Habit, {})
    }
}
