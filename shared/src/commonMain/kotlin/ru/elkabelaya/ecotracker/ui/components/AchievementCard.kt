package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material3.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Achievement(
    val id: String,
    val title: String,
    val description: String,
    val isUnlocked: Boolean,
    val progress: Float = 0f // 0.0 - 1.0
)

@Composable
fun AchievementCard(
    achievement: Achievement,
    onClick: () -> Unit = {}
) {
    var isPressed by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .animateContentSize(tween(300))
            .scale(scale = if (isPressed) 0.95f else 1f)
            //.animateBounds(tween(300))
            //.animateItemPlacement(tween(300))
            .clickable(onClick = {
                isPressed = true
                onClick()
                isPressed = false
            }),
        colors = CardDefaults.cardColors(
            containerColor = if (achievement.isUnlocked)
                Color(0xFFE8F5E9) else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Иконка с анимацией
            Box(
                modifier = Modifier
                    .size(48.dp)

                    //.animateItemOpacity(tween(500))
            ) {
                Icon(
                    imageVector = Icons.Default.Event,
                    contentDescription = null,
                    tint = if (achievement.isUnlocked)
                        Color(0xFF4CAF50) else Color.Gray,
                    modifier = Modifier.size(48.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = achievement.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (achievement.isUnlocked)
                        MaterialTheme.colorScheme.onSurface else Color.Gray
                )

                Text(
                    text = achievement.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // Прогресс-бар (если не разблокирован)
                if (!achievement.isUnlocked && achievement.progress > 0) {
                    Spacer(modifier = Modifier.height(8.dp))

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