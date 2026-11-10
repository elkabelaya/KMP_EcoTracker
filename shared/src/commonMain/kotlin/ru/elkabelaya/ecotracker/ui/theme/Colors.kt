package ru.elkabelaya.ecotracker.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Светлая тема
val LightPrimary = Color(0xFF4CAF50)
val LightSecondary = Color(0xFF81C784)
val LightBackground = Color(0xFFF5F7FA)
val LightSurface = Color(0xFFFFFFFF)
val LightError = Color(0xFFF44336)

// Темная тема
val DarkPrimary = Color(0xFF81C784)
val DarkSecondary = Color(0xFF4CAF50)
val DarkBackground = Color(0xFF121212)
val DarkSurface = Color(0xFF1E1E1E)
val DarkError = Color(0xFFCF6679)

// Общие цвета
val Success = Color(0xFF00E676)
val Warning = Color(0xFFFFB74D)
val Info = Color(0xFF2196F3)

val LightEcoTrackColors = darkColorScheme(
    primary = LightPrimary,
    secondary = LightSecondary,
    background = LightBackground,
    surface = LightSurface,
    error = LightError
)

val DarkEcoTrackColors = lightColorScheme(
    primary = DarkPrimary,
    secondary = DarkSecondary,
    background = DarkBackground,
    surface = DarkSurface,
    error = DarkError
)

