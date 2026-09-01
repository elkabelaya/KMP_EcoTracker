package ru.elkabelaya.ecotracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.elkabelaya.ecotracker.domain.Habit
import ru.elkabelaya.ecotracker.domain.Habits
import ru.elkabelaya.ecotracker.ui.components.HabitCard

@Composable
fun HabitScreen(
    habit: Habit?,
    onAddClick: (Habit) -> Unit,
) {
    var state = rememberTextFieldState("")
    Scaffold(
        // Верхняя панель (AppBar)
        topBar = {
            TopAppBar(
                title = { Text("Новая привычка") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        // Основной контент
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                TextField(state)
                Button({}, content = { Text("Сохранить") })
            }
        }
    )
}