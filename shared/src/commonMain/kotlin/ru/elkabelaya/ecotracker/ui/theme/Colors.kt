package ru.elkabelaya.ecotracker.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// ─── Light Palette ────────────────────────────────────────────────────────────
val LightPrimary = Color(0xFF4CAF50)
val LightOnPrimary = Color(0xFFFFFFFF)
val LightPrimaryContainer = Color(0xFFE8F5E9)
val LightOnPrimaryContainer = Color(0xFF2E7D32)
val LightSecondary = Color(0xFF2E7D32)
val LightOnSecondary = Color(0xFFFFFFFF)
val LightSecondaryContainer = Color(0xFFECEFF1)
val LightOnSecondaryContainer = Color(0xFF9E9E9E)
val LightTertiary = Color(0xFF66BB6A)
val LightOnTertiary = Color(0xFFFFFFFF)
val LightBackground = Color(0xFFF5F7FA)
val LightOnBackground = Color(0xFF212121)
val LightSurface = Color(0xFFFFFFFF)
val LightOnSurface = Color(0xFF212121)
val LightSurfaceVariant = Color(0xFFECEFF1)
val LightOnSurfaceVariant = Color(0xFF9E9E9E)
val LightError = Color(0xFFEF4444)
val LightOnError = Color(0xFFFFFFFF)
val LightErrorContainer = Color(0xFFFFEBEE)
val LightOnErrorContainer = Color(0xFFB71C1C)
val LightOutline = Color(0xFFE0E4E8)
val LightOutlineVariant = Color(0xFFE0E4E8)
val LightScrim = Color(0xFF000000)
val LightInverseSurface = Color(0xFF212121)
val LightOnInverseSurface = Color(0xFFFFFFFF)
val LightInverseOnSurface = Color(0xFFE0E4E8)

// ─── Dark Palette ─────────────────────────────────────────────────────────────
val DarkPrimary = Color(0xFF66BB6A)
val DarkOnPrimary = Color(0xFF0A280B)
val DarkPrimaryContainer = Color(0xFF2E7D32)
val DarkOnPrimaryContainer = Color(0xFFB6F0BA)
val DarkSecondary = Color(0xFF81C784)
val DarkOnSecondary = Color(0xFF0A280B)
val DarkSecondaryContainer = Color(0xFF1B281C)
val DarkOnSecondaryContainer = Color(0xFF81C784)
val DarkTertiary = Color(0xFF4CAF50)
val DarkOnTertiary = Color(0xFFFFFFFF)
val DarkBackground = Color(0xFF121212)
val DarkOnBackground = Color(0xFFFFFFFF)
val DarkSurface = Color(0xFF1E1E1E)
val DarkOnSurface = Color(0xFFFFFFFF)
val DarkSurfaceVariant = Color(0xFF2C2C2C)
val DarkOnSurfaceVariant = Color(0xFF9E9E9E)
val DarkError = Color(0xFFEF4444)
val DarkOnError = Color(0xFFFFFFFF)
val DarkErrorContainer = Color(0xFF4A1518)
val DarkOnErrorContainer = Color(0xFFF2B8B5)
val DarkOutline = Color(0xFF303030)
val DarkOutlineVariant = Color(0xFF2F4C31)
val DarkScrim = Color(0xFF000000)
val DarkInverseSurface = Color(0xFFFFFFFF)
val DarkOnInverseSurface = Color(0xFF1E1E1E)
val DarkInverseOnSurface = Color(0xFF303030)

// ─── Category Colors (shared between themes) ─────────────────────────────────
val CategoryEcology = Color(0xFF4CAF50)
val CategoryWater = Color(0xFF2196F3)
val CategoryTransport = Color(0xFF9C27B0)
val CategoryRecycle = Color(0xFFFF9800)
val CategoryEnergy = Color(0xFFFFC107)

// ─── Light Color Scheme ───────────────────────────────────────────────────────
val LightEcoTrackColors: ColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    error = LightError,
    onError = LightOnError,
    errorContainer = LightErrorContainer,
    onErrorContainer = LightOnErrorContainer,
    outline = LightOutline,
    outlineVariant = LightOutlineVariant,
    scrim = LightScrim,
    inverseSurface = LightInverseSurface,
    // onInverseSurface = LightOnInverseSurface,
    inverseOnSurface = LightInverseOnSurface
)

// ─── Dark Color Scheme ────────────────────────────────────────────────────────
val DarkEcoTrackColors: ColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,
    tertiary = DarkTertiary,
    onTertiary = DarkOnTertiary,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    error = DarkError,
    onError = DarkOnError,
    errorContainer = DarkErrorContainer,
    onErrorContainer = DarkOnErrorContainer,
    outline = DarkOutline,
    outlineVariant = DarkOutlineVariant,
    scrim = DarkScrim,
    inverseSurface = DarkInverseSurface,
    // onInverseSurface = DarkOnInverseSurface,
    inverseOnSurface = DarkInverseOnSurface
)
