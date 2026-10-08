package ru.elkabelaya.ecotracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.elkabelaya.ecotracker.domain.model.Habit
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.ui.components.EnumDropdownMenu
import ru.elkabelaya.ecotracker.ui.viewmodels.AddHabitViewModel

@Composable
fun HabitScreen(
    viewModel: AddHabitViewModel,
    onBack: () -> Unit
) {
    val titleState = rememberTextFieldState("")
    val categoryState = remember{mutableStateOf(HabitCategory.TRANSPORT)}

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Новая привычка") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                navigationIcon = {

                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }

                }
            )
        },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                TextField(titleState)
                EnumDropdownMenu(
                    HabitCategory.entries,
                    categoryState.value,
                    {
                        categoryState.value = it
                    },
                    {
                        it.toString()
                    }
                )
                Button({
                    viewModel.addHabit(titleState.text.toString(), categoryState.value) {
                        onBack()
                    }
                },
                    content = { Text("Сохранить") }
                )
            }
        }
    )
}