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
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.LinearProgressIndicator
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
import ru.elkabelaya.ecotracker.domain.model.Achievement
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.preview.Achievement
import ru.elkabelaya.ecotracker.ui.preview.AchievementUnlocked
import ru.elkabelaya.ecotracker.ui.preview.Preview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * Achievement card — shows an achievement with icon, title, description,
 * optional status chip and optional progress bar.
 *
 * Figma: `EcoTrack / Cards / Achievement`
 * - 346×72 (compact) or 346×78 (with progress), bg surface, radius 16 dp
 * - Left: icon 40×40 in category-colored circle
 * - Center: title (Body 14 SemiBold) + description (Body 12 Regular)
 * - Right: [EcoChip] badge ("Active" / "Locked") or progress bar
 */
@Composable
fun EcoAchievementCard(
    achievement: Achievement,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.EmojiEvents,
    iconBackgroundColor: Color = MaterialTheme.colorScheme.primary,
    showProgress: Boolean = false,
    badgeText: String? = null,
    badgeColor: Color = MaterialTheme.colorScheme.primary,
) {
    val isUnlocked = achievement.isUnlocked

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.Radius.xl))
            .background(
                if (isUnlocked) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    MaterialTheme.colorScheme.surface
                }
            )
            .shadow(
                elevation = Dimens.Elevation.low,
                shape = RoundedCornerShape(Dimens.Radius.xl)
            )
            .clickable { onClick() }
            .padding(Dimens.Paddings.m),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Icon
            androidx.compose.foundation.layout.Box(
                modifier = Modifier
                    .size(Dimens.Size.l)
                    .clip(RoundedCornerShape(Dimens.Radius.full))
                    .background(
                        if (isUnlocked) {
                            iconBackgroundColor
                        } else {
                            MaterialTheme.colorScheme.surfaceVariant
                        }
                    ),
                contentAlignment = Alignment.Center,
            ) {
                androidx.compose.material3.Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (isUnlocked) {
                        Color.White
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(Modifier.width(Dimens.Paddings.m))

            // Text
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = achievement.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = achievement.description,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )

                // Optional progress bar
                if (showProgress && !isUnlocked && achievement.progress > 0f) {
                    Spacer(Modifier.height(Dimens.Paddings.s))
                    LinearProgressIndicator(
                        progress = { achievement.progress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .clip(RoundedCornerShape(Dimens.Radius.full)),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f),
                    )
                }
            }

            // Optional badge
            if (badgeText != null) {
                Spacer(Modifier.width(Dimens.Paddings.s))
                EcoChip(
                    text = badgeText,
                    containerColor = badgeColor,
                )
            }
        }
    }
}

@AppPreview
@Composable
private fun EcoAchievementCardPreview() {
    EcoTrackTheme {
        Column {
            EcoAchievementCard(Preview.Achievement, badgeText = "60%", badgeColor = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.height(12.dp))
            EcoAchievementCard(Preview.AchievementUnlocked, badgeText = "Active")
        }
    }
}
