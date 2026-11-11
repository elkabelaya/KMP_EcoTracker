package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.elkabelaya.ecotracker.domain.model.Achievement
import ru.elkabelaya.ecotracker.ui.theme.Dimens

@Suppress("MagicNumber")
@Composable
fun AchievementCard(
    achievement: Achievement,
    onClick: () -> Unit = {}
) {
    var isPressed by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.Paddings.s)
            .animateContentSize(tween(300))
            .scale(scale = if (isPressed) 0.95f else 1f)
            // .animateBounds(tween(300))
            // .animateItemPlacement(tween(300))
            .clickable(onClick = {
                isPressed = true
                onClick()
                isPressed = false
            }),
        colors = CardDefaults.cardColors(
            containerColor = if (achievement.isUnlocked) {
                Color(0xFFE8F5E9)
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            }
        )
    ) {
        Row(
            modifier = Modifier.padding(Dimens.Paddings.m),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Иконка с анимацией
            Box(
                modifier = Modifier
                    .size(Dimens.Size.xl)

                // .animateItemOpacity(tween(500))
            ) {
                Icon(
                    imageVector = Icons.Default.Event,
                    contentDescription = null,
                    tint = if (achievement.isUnlocked) {
                        Color(0xFF4CAF50)
                    } else {
                        Color.Gray
                    },
                    modifier = Modifier.size(Dimens.Size.xl)
                )
            }

            Spacer(modifier = Modifier.width(Dimens.Size.m))

            Column {
                Text(
                    text = achievement.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = if (achievement.isUnlocked) {
                        MaterialTheme.colorScheme.onSurface
                    } else {
                        Color.Gray
                    }
                )

                Text(
                    text = achievement.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // Прогресс-бар (если не разблокирован)
                if (!achievement.isUnlocked && achievement.progress > 0) {
                    Spacer(modifier = Modifier.height(Dimens.Size.s))

                    LinearProgressIndicator(
                        progress = { achievement.progress },
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFF4CAF50),
                        trackColor = Color.Gray.copy(alpha = 0.3f),
                        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun AchievementCardPreview() {
    MaterialTheme {
        AchievementCard(Achievement("1", "title", "description", false))
    }
}
