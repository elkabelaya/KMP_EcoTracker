package ru.elkabelaya.ecotracker.domain.usecase

import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.domain.repository.HabitRepository

class AddHabitUseCase(
    private val repository: HabitRepository
) {
    suspend operator fun invoke(
        title: String,
        category: HabitCategory
    ): Result<Habit> {
        if (title.isBlank()) {
            return Result.failure(Exception("Название не может быть пустым"))
        }

        if (title.length > 100) {
            return Result.failure(Exception("Название слишком длинное"))
        }

        val habit = Habit(
            id = 0,
            title = title.trim(),
            category = category
        )

        return repository.add(habit).map { habit }
    }
}