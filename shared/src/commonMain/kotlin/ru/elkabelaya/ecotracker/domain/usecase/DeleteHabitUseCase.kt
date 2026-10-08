package ru.elkabelaya.ecotracker.domain.usecase

import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.domain.repository.HabitRepository

class DeleteHabitUseCase(
        private val repository: HabitRepository
    ) {
        suspend operator fun invoke(
            id: String
        ) {

            repository.delete(id)
        }
    }