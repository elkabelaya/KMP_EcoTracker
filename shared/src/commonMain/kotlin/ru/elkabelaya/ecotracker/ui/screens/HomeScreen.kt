package ru.elkabelaya.ecotracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.domain.Habit
import ru.elkabelaya.ecotracker.domain.Habits
import ru.elkabelaya.ecotracker.ui.components.HabitCard

@Composable
fun HomeScreen(
    habits: Habits, // Данные из ViewModel (пока заглушка)
    onAddClick: () -> Unit,
    onHabitClick: (String) -> Unit // ID привычки
) {
    Scaffold(
        // Верхняя панель (AppBar)
        topBar = {
            TopAppBar(
                title = { Text("Мои привычки") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        // Плавающая кнопка (FAB) - автоматически позиционируется
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
//                Icon(
//                    imageVector = androidx.compose.material.icons.Icons.Default.Add,
//                    contentDescription = "Добавить"
//                )
            }
        },

        // Основной контент
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = paddingValues
            ) {
                items(habits, key = { it.id }) { habit ->
                    HabitCard(
                        habit = habit,
                        onClick = { onHabitClick(habit.id) }
                    )
                }
            }
        }
    )
}