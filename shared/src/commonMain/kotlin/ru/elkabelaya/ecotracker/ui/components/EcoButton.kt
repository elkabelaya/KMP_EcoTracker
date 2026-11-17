package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

// ─── Button Variant ───────────────────────────────────────────────────────────

/**
 * Figma: `EcoTrack / Actions / Button`
 *
 * | Variant   | bg                   | border            | radius  | height |
 * |-----------|----------------------|-------------------|---------|--------|
 * | Primary   | primary              | —                | 14 dp   | 50 dp  |
 * | Secondary | primaryContainer     | outlineVariant    | 14 dp   | 48 dp  |
 * | Danger    | error                | —                | 12 dp   | 48 dp  |
 * | Prominent | primary + glow       | —                | 20 dp   | 52 dp  |
 */

/**
 * EcoTracker button with 4 visual variants.
 */
@Composable
fun EcoButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: EcoButtonVariant = EcoButtonVariant.Primary,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
) {
    val backgroundColor: Color
    val borderColor: Color?
    val contentColor: Color
    val radius: androidx.compose.ui.unit.Dp
    val height: androidx.compose.ui.unit.Dp
    val hasGlow: Boolean

    when (variant) {
        EcoButtonVariant.Primary -> {
            backgroundColor = MaterialTheme.colorScheme.primary
            borderColor = null
            contentColor = MaterialTheme.colorScheme.onPrimary
            radius = Dimens.Radius.l
            height = Dimens.Height.buttonPrimary
            hasGlow = false
        }
        EcoButtonVariant.Secondary -> {
            backgroundColor = MaterialTheme.colorScheme.primaryContainer
            borderColor = MaterialTheme.colorScheme.outlineVariant
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            radius = Dimens.Radius.l
            height = Dimens.Height.buttonSecondary
            hasGlow = false
        }
        EcoButtonVariant.Danger -> {
            backgroundColor = MaterialTheme.colorScheme.error
            borderColor = null
            contentColor = MaterialTheme.colorScheme.onError
            radius = Dimens.Radius.m
            height = Dimens.Height.buttonSecondary
            hasGlow = false
        }
        EcoButtonVariant.Prominent -> {
            backgroundColor = MaterialTheme.colorScheme.primary
            borderColor = null
            contentColor = MaterialTheme.colorScheme.onPrimary
            radius = Dimens.Radius.xxl
            height = Dimens.Height.buttonProminent
            hasGlow = true
        }
    }

    var m: Modifier = modifier
        .fillMaxWidth()
        .height(height)
        .clip(RoundedCornerShape(radius))
        .background(backgroundColor)

    if (borderColor != null) {
        m = m.border(
            width = Dimens.Stroke.thin,
            color = borderColor,
            shape = RoundedCornerShape(radius)
        )
    }

    if (hasGlow) {
        m = m.shadow(
            elevation = Dimens.Elevation.medium,
            shape = RoundedCornerShape(radius),
            ambientColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
            spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
        )
    }

    if (enabled) {
        m = m.clickable { onClick() }
    }

    Box(
        modifier = m,
        contentAlignment = Alignment.Center,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                color = contentColor
            )
        }
    }
}

// ─── Convenience overloads ───────────────────────────────────────────────────

/** Primary (Войти) — solid green, 50 dp, radius 14 dp */
@Composable
fun EcoButtonPrimary(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) = EcoButton(text, onClick, modifier, EcoButtonVariant.Primary, enabled)

/** Secondary (Создать аккаунт) — container bg + border, 48 dp */
@Composable
fun EcoButtonSecondary(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) = EcoButton(text, onClick, modifier, EcoButtonVariant.Secondary, enabled)

/** Danger (Выйти) — red, 48 dp, radius 12 dp */
@Composable
fun EcoButtonDanger(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) = EcoButton(text, onClick, modifier, EcoButtonVariant.Danger, enabled)

/** Prominent (Сохранить привычку) — green + glow, 52 dp, radius 20 dp */
@Composable
fun EcoButtonProminent(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
) = EcoButton(text, onClick, modifier, EcoButtonVariant.Prominent, enabled, leadingIcon)

@AppPreview
@Composable
private fun EcoButtonPreview() {
    EcoTrackTheme {
        Column {
            EcoButton("Войти", {}, variant = EcoButtonVariant.Primary)
            Spacer(Modifier.height(12.dp))
            EcoButton("Создать аккаунт", {}, variant = EcoButtonVariant.Secondary)
            Spacer(Modifier.height(12.dp))
            EcoButton("Выйти", {}, variant = EcoButtonVariant.Danger)
            Spacer(Modifier.height(12.dp))
            EcoButton("Сохранить привычку", {}, variant = EcoButtonVariant.Prominent)
        }
    }
}
