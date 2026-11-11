package ru.elkabelaya.ecotracker.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ecotracker.shared.generated.resources.Res
import ecotracker.shared.generated.resources.home_statistics_accessability
import ecotracker.shared.generated.resources.home_title
import ru.elkabelaya.ecotracker.ui.components.HabitCard
import ru.elkabelaya.ecotracker.ui.extensions.Icon
import ru.elkabelaya.ecotracker.ui.extensions.Text
import ru.elkabelaya.ecotracker.ui.viewmodels.HabitViewModel

@Composable
fun HomeScreen(
    viewModel: HabitViewModel,
    onAddClick: () -> Unit,
    onHabitClick: (String) -> Unit,
    onStatisticsClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        Res.string.home_title,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                actions = {
                    IconButton(onClick = onStatisticsClick) {
                        Icon(
                            imageVector = Icons.Default.Stars,
                            contentDescription = Res.string.home_statistics_accessability
                        )
                    }
                }
            )
        },

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
