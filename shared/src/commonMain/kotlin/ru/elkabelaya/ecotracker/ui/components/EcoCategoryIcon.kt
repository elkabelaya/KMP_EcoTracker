package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Recommend
import androidx.compose.material.icons.filled.Recycling
import androidx.compose.material.icons.filled.WbIncandescent
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

@Composable
private fun HabitCategoryIcon(category: HabitCategory): ImageVector = when (category) {
    HabitCategory.ECOLOGY -> Icons.Default.Eco
    HabitCategory.WATER -> Icons.Default.Recommend
    HabitCategory.TRANSPORT -> Icons.Default.DirectionsBike
    HabitCategory.RECYCLE -> Icons.Default.Recycling
    HabitCategory.ENERGY -> Icons.Default.WbIncandescent
}

/**
 * A colored circle containing a habit category icon.
 *
 * Figma: `EcoTrack / Icons / Habit category`
 * - 40×40 circle, filled with category color, white icon 24 dp centered.
 *
 * @param size default 40 dp (use 36 dp for tiles).
 */
@Composable
fun EcoCategoryIcon(
    category: HabitCategory,
    modifier: Modifier = Modifier,
    size: Dp = Dimens.Size.l,
    backgroundColor: Color? = null,
    iconTint: Color = Color.White,
) {
    val bg = backgroundColor ?: categoryToColor(category)

    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(bg),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = HabitCategoryIcon(category),
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(size * Dimens.Percent.medium)
        )
    }
}

/**
 * Returns the accent [Color] for a [HabitCategory] using the current theme palette.
 */
@Composable
private fun categoryToColor(category: HabitCategory): Color =
    ru.elkabelaya.ecotracker.ui.theme.habitCategoryColor(category)

@AppPreview
@Composable
private fun EcoCategoryIconPreview() {
    EcoTrackTheme {
        Row {
            HabitCategory.entries.forEach {
                EcoCategoryIcon(category = it)
                Spacer(Modifier.size(12.dp))
            }
        }
    }
}
