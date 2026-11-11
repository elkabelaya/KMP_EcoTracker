package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.ui.theme.Dimens

@Composable
fun HabitCard(
    habit: Habit,
    onClick: () -> Unit // Клик по карточке
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.Paddings.m, vertical = Dimens.Paddings.s),
        elevation = CardDefaults.cardElevation(defaultElevation = Dimens.Evaluation.m),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(Dimens.Paddings.m),
            verticalAlignment = Alignment.CenterVertically
        ) {
//            // Иконка (заглушка)
//            Icon(
//                imageVector = androidx.compose.material.icons.Icons.Default.Check,
//                contentDescription = null,
//                tint = if (habit.isCompleted) Color(0xFF4CAF50) else MaterialTheme.colorScheme.onSurfaceVariant,
//                modifier = Modifier.size(32.dp)
//            )

            Spacer(modifier = Modifier.width(Dimens.Paddings.m))

            Column {
                Text(
                    text = habit.title,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = habit.category.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Толкает дату вправо

            Text(
                text = habit.date.toString(),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}
