package ru.elkabelaya.ecotracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

private val EcoFontFamily = FontFamily.Default

/**
 * Typography matching the Figma design tokens:
 *
 * | Figma Token                    | Material3 Slot | Size | Weight   | Line Height | Tracking  |
 * |--------------------------------|----------------|------|----------|-------------|-----------|
 * | Heading/22 · Bold · 27.5     | headlineLarge  | 22sp | Bold     | 27.5sp     | —         |
 * | Title/16 · Bold · 24         | titleLarge     | 16sp | Bold     | 24sp       | —         |
 * | Body/14 · Semi Bold · 21     | titleMedium    | 14sp | SemiBold | 21sp       | —         |
 * | Body/14 · Semi Bold · 20     | titleSmall     | 14sp | SemiBold | 20sp       | —         |
 * | Body/14 · Medium · 20        | bodyLarge      | 14sp | Medium   | 20sp       | —         |
 * | Body/14 · Regular · 21       | bodyMedium     | 14sp | Normal   | 21sp       | —         |
 * | Body/12 · Semi Bold · 16     | bodySmall      | 12sp | SemiBold | 16sp       | —         |
 * | Body/12 · Medium · 18        | labelLarge     | 12sp | Medium   | 18sp       | —         |
 * | Body/12 · Regular · 16       | labelMedium    | 12sp | Normal   | 16sp       | —         |
 * | Caption/10 · Semi Bold · 15  | labelSmall     | 10sp | SemiBold | 15sp       | 0.1em     |
 * | Caption/10 · Regular · 15    | (custom)       | 10sp | Normal   | 15sp       | —         |
 * | Caption/8 · Regular · 12     | (custom)       |  8sp | Normal   | 12sp       | —         |
 */
val EcoTrackTypography = Typography(
    // Display — unused in current Figma but kept for completeness
    displayLarge = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    displayMedium = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    displaySmall = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),

    // Heading
    headlineLarge = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 27.5.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 27.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),

    // Title
    titleLarge = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),
    titleSmall = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    // Body
    bodyLarge = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),
    bodySmall = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),

    // Label / Caption
    labelLarge = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 18.sp
    ),
    labelMedium = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = EcoFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.1.em
    )
)

// ─── Additional custom styles used in Figma ──────────────────────────────────

/** Caption/10 · Regular · 15 — used for field values, secondary text */
val EcoCaptionRegular = TextStyle(
    fontFamily = EcoFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 15.sp
)

/** Caption/9 · Medium · 11.25 — used for achievement tiles */
val EcoCaptionMedium9 = TextStyle(
    fontFamily = EcoFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 9.sp,
    lineHeight = 11.25.sp
)

/** Caption/8 · Regular · 12 — used for metric captions */
val EcoCaptionRegular8 = TextStyle(
    fontFamily = EcoFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 8.sp,
    lineHeight = 12.sp
)

/** Section header: Caption/10 · Semi Bold · 15 · Uppercase · Tracking */
val EcoSectionHeader = TextStyle(
    fontFamily = EcoFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 10.sp,
    lineHeight = 15.sp,
    letterSpacing = 0.1.em
)
