package ru.elkabelaya.ecotracker.data.network

import ru.elkabelaya.ecotracker.data.dto.HabitDto

interface HabitApiRepository {
    suspend fun getHabits(): Result<List<HabitDto>>
    suspend fun createHabit(habit: HabitDto): Result<HabitDto>
    suspend fun updateHabit(id: String, habit: HabitDto): Result<HabitDto>
    suspend fun deleteHabit(id: String): Result<Unit>
}
