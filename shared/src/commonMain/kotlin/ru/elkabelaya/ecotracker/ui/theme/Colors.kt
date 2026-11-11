package ru.elkabelaya.ecotracker.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.elkabelaya.ecotracker.ui.screens.StatisticsScreen

val LightPrimary = Color(0xFF4CAF50)
val LightSecondary = Color(0xFF81C784)
val LightBackground = Color(0xFFF5F7FA)
val LightSurface = Color(0xFFF5F7FA)
val LightOnSurface = Color(0xFF212121)
val LightError = Color(0xFFF44336)

val DarkPrimary = Color(0xFF81C784)
val DarkSecondary = Color(0xFF4CAF50)
val DarkBackground = Color(0xFF121212)
val DarkSurface = Color(0xFF1E1E1E)
val DarkOnSurface = Color(0xFFFFFFFF)
val DarkError = Color(0xFFCF6679)

val LightEcoTrackColors = darkColorScheme(
    primary = LightPrimary,
    secondary = LightSecondary,
    background = LightBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    error = LightError
)

val DarkEcoTrackColors = lightColorScheme(
    primary = DarkPrimary,
    secondary = DarkSecondary,
    background = DarkBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    error = DarkError
)

@Preview
@Composable
fun StatisticsScreenPreview() {
    MaterialTheme {
        StatisticsScreen(listOf(1f, 3f, 7f), listOf(1f, 3f, 7f)) {}
    }
}
