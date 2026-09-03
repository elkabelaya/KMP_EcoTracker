package ru.elkabelaya.ecotracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import ru.elkabelaya.ecotracker.domain.model.Habits
import ru.elkabelaya.ecotracker.ui.components.HabitCard
import ru.elkabelaya.ecotracker.ui.viewmodels.HabitViewModel

@Composable
fun HomeScreen(
    viewModel: HabitViewModel,
    onAddClick: () -> Unit,
    onHabitClick: (String) -> Unit // ID привычки
) {
    val uiState by viewModel.uiState.collectAsState()
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
                items(uiState.habits, key = { it.id }) { habit ->
                    HabitCard(
                        habit = habit,
                        onClick = { onHabitClick(habit.id) }
                    )
                }
            }
        }
    )
}