package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.CategoryWater
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * Profile card — shows user avatar, name, email and sync status.
 *
 * Figma: `EcoTrack / Account / Profile`
 * - 346×92, bg surface, radius 16 dp
 * - Left: avatar 32×32 rounded-8 (blue bg with initial letter)
 * - Center: name (Title 16 Bold) + email (Body 12 Regular)
 * - Right: green dot + "Синхронизировано" or similar
 *
 * @param avatarColor background color for the avatar circle.
 * @param avatarText a single letter (e.g. "A") shown on the avatar.
 */
@Composable
fun EcoProfileCard(
    name: String,
    email: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    avatarColor: Color = CategoryWater,
    avatarText: String = name.firstOrNull()?.uppercase() ?: "",
    statusText: String?,
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
        // Avatar
        Box(
            modifier = Modifier
                .size(Dimens.Size.m)
                .clip(RoundedCornerShape(Dimens.Radius.s))
                .background(avatarColor),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = avatarText,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
            )
        }

        Spacer(Modifier.width(Dimens.Paddings.m))

        // Name + email
        Column(Modifier.weight(1f)) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = email,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        // Status indicator
        if (statusText != null) {
            Spacer(Modifier.width(Dimens.Paddings.s))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(statusColor)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = statusText,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

@AppPreview
@Composable
private fun EcoProfileCardPreview() {
    EcoTrackTheme {
        EcoProfileCard(
            "Anna",
            "anna@example.com",
            statusText = "ok"
        )
    }
}
