package ru.elkabelaya.ecotracker.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.elkabelaya.ecotracker.domain.model.Habits
import ru.elkabelaya.ecotracker.domain.repository.HabitRepository

class GetHabitsUseCase(
    private val repository: HabitRepository
) {
    suspend operator fun invoke(): Flow<Habits> {
        return repository.getHabits()
    }
}
