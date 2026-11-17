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
import androidx.compose.material.icons.filled.Cloud
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
import ru.elkabelaya.ecotracker.ui.theme.EcoCaptionRegular
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * Sync status row — shows a sync/cloud operation with its status.
 *
 * Figma: `EcoTrack / Account / Sync`
 * - 346×59, bg surface, radius 16 dp
 * - Left: icon 32×32
 * - Center: title (Body 14 SemiBold) + description (Caption 10 Regular)
 * - Right: status badge pill ("ОК" green, "Ошибка" red, etc.)
 *
 * @param statusColor controls the badge color.
 */
@Composable
fun EcoSyncRow(
    title: String,
    description: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Cloud,
    iconColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    statusText: String,
    statusColor: Color = MaterialTheme.colorScheme.primary,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.Radius.xl))
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onClick() }
            .padding(Dimens.Paddings.m),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Icon
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(Dimens.Size.m)
                .clip(RoundedCornerShape(Dimens.Radius.s))
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

        // Text
        Column(Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = description,
                style = EcoCaptionRegular,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        // Status badge
        Text(
            text = statusText,
            style = MaterialTheme.typography.labelSmall,
            color = Color.White,
            modifier = Modifier
                .background(statusColor, RoundedCornerShape(Dimens.Radius.full))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}

@AppPreview
@Composable
private fun EcoSyncRowPreview() {
    EcoTrackTheme {
        EcoSyncRow(
            title = "Google Cloud",
            description = "Синхронизировано · 2 мин назад",
            statusText = "Ok"
        )
    }
}
