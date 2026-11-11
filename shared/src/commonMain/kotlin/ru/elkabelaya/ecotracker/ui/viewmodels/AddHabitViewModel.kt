package ru.elkabelaya.ecotracker.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.domain.usecase.AddHabitUseCase

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
