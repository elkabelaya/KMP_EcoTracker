package ru.elkabelaya.ecotracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ecotracker.shared.generated.resources.Res
import ecotracker.shared.generated.resources.add_habit_save
import ecotracker.shared.generated.resources.add_habit_title
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.ui.components.BackButton
import ru.elkabelaya.ecotracker.ui.components.EnumDropdownMenu
import ru.elkabelaya.ecotracker.ui.extensions.Text
import ru.elkabelaya.ecotracker.ui.viewmodels.AddHabitViewModel

@Composable
fun HabitScreen(
    viewModel: AddHabitViewModel,
    onBack: () -> Unit
) {
    val titleState = rememberTextFieldState("")
    val categoryState = remember { mutableStateOf(HabitCategory.TRANSPORT) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                    Res.string.add_habit_title,
                    style = MaterialTheme.typography.titleMedium
                )
                },
                navigationIcon = { BackButton(onBack = onBack) }

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
                Button(
                    {
                        viewModel.addHabit(titleState.text.toString(), categoryState.value) {
                            onBack()
                        }
                    },
                    content = {
                        Text(
                            Res.string.add_habit_save,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                )
            }
        }
    )
}
