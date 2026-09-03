package ru.elkabelaya.ecotracker.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.domain.model.Habits
import ru.elkabelaya.ecotracker.domain.repository.HabitRepository

class HabitRepositoryImpl: HabitRepository {
    override fun getHabits(): Flow<Habits> = flow {
        listOf(Habit("1", "", HabitCategory.TRANSPORT, false, ""))
    }

    override suspend fun add(habit: Habit): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun update(habit: Habit): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getByCategory(category: HabitCategory): Flow<Habits> {
        TODO("Not yet implemented")
    }
}