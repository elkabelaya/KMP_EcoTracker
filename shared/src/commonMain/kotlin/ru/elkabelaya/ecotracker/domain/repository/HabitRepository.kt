package ru.elkabelaya.ecotracker.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.domain.model.Habits

interface HabitRepository {
    fun getHabits(): Flow<Habits>
    suspend fun add(habit: Habit): Result<Unit>
    suspend fun update(habit: Habit): Result<Unit>
    suspend fun delete(id: String): Result<Unit>
    suspend fun getByCategory(category: HabitCategory): Flow<Habits>
}