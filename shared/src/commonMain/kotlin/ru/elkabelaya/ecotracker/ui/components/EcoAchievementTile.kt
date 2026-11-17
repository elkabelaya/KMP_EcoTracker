package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
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
import ru.elkabelaya.ecotracker.ui.theme.EcoCaptionMedium9
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * Compact achievement tile for grid layouts.
 *
 * Figma: `EcoTrack / Cards / Achievement tile`
 * - 110×85, bg surface, radius 20 dp
 * - Icon 36×36 circle at top-center
 * - Small dot indicator
 * - Title: Caption 9 Medium, centered
 */
@Composable
fun EcoAchievementTile(
    title: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.EmojiEvents,
    iconBackgroundColor: Color = MaterialTheme.colorScheme.primary,
    unlocked: Boolean = true,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(Dimens.Radius.xxl))
            .background(
                if (unlocked) {
                    MaterialTheme.colorScheme.surface
                } else {
                    MaterialTheme.colorScheme.surfaceVariant
                }
            )
            .clickable { onClick() }
            .padding(Dimens.Paddings.s),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Icon
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(Dimens.Misc.tileIcon)
                .clip(CircleShape)
                .background(
                    if (unlocked) {
                        iconBackgroundColor
                    } else {
                        MaterialTheme.colorScheme.outlineVariant
                    }
                ),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (unlocked) {
                    Color.White
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(Modifier.height(Dimens.Paddings.s))

        // Dot indicator
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(Dimens.Misc.tileDot)
                .clip(CircleShape)
                .background(
                    if (unlocked) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
        )

        Spacer(Modifier.height(4.dp))

        // Title
        Text(
            text = title,
            style = EcoCaptionMedium9,
            color = if (unlocked) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            },
            maxLines = 2,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
        )
    }
}

@AppPreview
@Composable
private fun EcoAchievementTilePreview() {
    EcoTrackTheme {
        Row {
            EcoAchievementTile("Зелёная неделя", unlocked = true)
            Spacer(Modifier.size(8.dp))
            EcoAchievementTile("Эко-новичок", unlocked = false)
        }
    }
}
