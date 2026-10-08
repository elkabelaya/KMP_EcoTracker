package ru.elkabelaya.ecotracker.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.domain.model.Habits
import ru.elkabelaya.ecotracker.domain.usecase.AddHabitUseCase
import ru.elkabelaya.ecotracker.domain.usecase.GetHabitsUseCase


class AddHabitViewModel(
    private val addHabitUseCase: AddHabitUseCase,
) : ViewModel() {

    fun addHabit(title: String, category: HabitCategory, onComplete: () -> Unit) {
        viewModelScope.launch {
            addHabitUseCase(title, category).map {
                onComplete()
            }
        }
    }
}