package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoSectionHeader
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * Settings section — a titled group of setting rows.
 *
 * Figma: `EcoTrack / Settings / Information` + `EcoTrack / Settings / Preferences`
 * - Section header: Caption 10 SemiBold, uppercase, tracking 0.1em, onSurfaceVariant
 * - Each row: 48 dp tall, icon 32×32, label, optional chevron or switch
 */

// ─── Section container ───────────────────────────────────────────────────────

@Composable
fun EcoSettingsSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Header
        Text(
            text = title.uppercase(),
            style = EcoSectionHeader,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                start = Dimens.Paddings.m,
                bottom = Dimens.Paddings.s
            )
        )

        // Rows
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(Dimens.Radius.xl))
                .background(MaterialTheme.colorScheme.surface),
        ) {
            content()
        }
    }
}

// ─── Single row ──────────────────────────────────────────────────────────────

/**
 * A single row inside an [EcoSettingsSection].
 *
 * @param trailing composable for the right side (chevron, switch, value text, etc.)
 */
@Composable
fun EcoSettingsRow(
    label: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    iconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    isLast: Boolean = false,
    onClick: (() -> Unit)? = null,
    trailing: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(24.dp)
        )
    },
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.Height.settingsRow)
            .padding(horizontal = Dimens.Paddings.m)
            .then(
                if (onClick != null) Modifier.clickable { onClick() } else Modifier
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Icon in rounded square
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(Dimens.Size.m)
                .clip(RoundedCornerShape(Dimens.Radius.m))
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(Modifier.width(Dimens.Paddings.m))

        // Label
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f),
        )

        // Trailing
        trailing()
    }

    // Divider
    if (!isLast) {
        Spacer(
            Modifier
                .fillMaxWidth()
                .padding(start = Dimens.Size.m + Dimens.Paddings.m)
                .height(Dimens.Stroke.thin)
                .background(MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
        )
    }
}

@AppPreview
@Composable
private fun EcoSettingsSectionPreview() {
    EcoTrackTheme {
        EcoSettingsSection("Настройки") {
            EcoSettingsRow(
                label = "О приложении",
                icon = Icons.Default.ChevronRight,
            )
            EcoSettingsRow(
                label = "Уведомления",
                icon = Icons.Default.ChevronRight,
                isLast = true,
            )
        }
    }
}
