package ru.elkabelaya.ecotracker.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.domain.model.Habits
import ru.elkabelaya.ecotracker.domain.usecase.AddHabitUseCase

data class HabitUiState(
    val habits: Habits = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class HabitViewModel(
    private val addHabitUseCase: AddHabitUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HabitUiState())
    val uiState: StateFlow<HabitUiState> = _uiState.asStateFlow()

    init {
        loadHabits()
    }

    private fun loadHabits() {
        _uiState.value = _uiState.value.copy(
            isLoading = true,
            habits = listOf()
        )
    }

    fun addHabit(title: String, category: HabitCategory) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            addHabitUseCase(title, category).map {
                _uiState.value = _uiState.value.copy(isLoading = false)
            }
            .recover {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = it.toString()
                )
            }
        }
    }
}