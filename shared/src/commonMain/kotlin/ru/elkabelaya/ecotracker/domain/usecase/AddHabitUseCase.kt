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
        var error: String? = null
        if (title.isBlank()) {
            error = "Название не может быть пустым"
        }

        if (title.length > MAX_LENGTH) {
            error = "Название слишком длинное"
        }

        if (error.isNullOrEmpty()) {
            val habit = Habit(
                id = "",
                title = title.trim(),
                category = category
            )

            return repository.add(habit).map { habit }
        } else {
            return Result.failure(Exception(error))
        }
    }

    private companion object {
        const val MAX_LENGTH = 100
    }
}
