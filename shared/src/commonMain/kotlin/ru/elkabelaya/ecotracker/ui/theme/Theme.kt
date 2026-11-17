package ru.elkabelaya.ecotracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.elkabelaya.ecotracker.domain.model.HabitCategory

/**
 * Root theme composable for EcoTracker.
 *
 * Apply at the top of your app:
 * ```
 * Theme {
 *     MyApp()
 * }
 * ```
 */
@Composable
fun EcoTrackTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkEcoTrackColors else LightEcoTrackColors,
        typography = EcoTrackTypography,
        content = content
    )
}

// ─── Category color helper ───────────────────────────────────────────────────

/**
 * Returns the accent color for a [HabitCategory].
 * The same palette is used in both light and dark themes —
 * the category colors are vibrant enough to work on both backgrounds.
 */
@Composable
fun habitCategoryColor(category: HabitCategory): Color = when (category) {
    HabitCategory.ECOLOGY -> CategoryEcology
    HabitCategory.WATER -> CategoryWater
    HabitCategory.TRANSPORT -> CategoryTransport
    HabitCategory.RECYCLE -> CategoryRecycle
    HabitCategory.ENERGY -> CategoryEnergy
}
