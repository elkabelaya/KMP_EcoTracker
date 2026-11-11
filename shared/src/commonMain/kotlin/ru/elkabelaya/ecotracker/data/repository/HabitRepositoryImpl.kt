package ru.elkabelaya.ecotracker.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.elkabelaya.ecotracker.data.providers.TimeProvider
import ru.elkabelaya.ecotracker.db.EcoTrackDatabase
import ru.elkabelaya.ecotracker.db.Habit_table
import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.domain.model.Habits
import ru.elkabelaya.ecotracker.domain.repository.HabitRepository

@Suppress("TooGenericExceptionCaught")
class HabitRepositoryImpl(
    private val database: EcoTrackDatabase,
    private val timeProvider: TimeProvider
) : HabitRepository {
    override fun getHabits(): Flow<Habits> = flow {
        database.habitQueries.selectAllHabits()
            .asFlow()
            .mapToList(Dispatchers.Default)
            .collect { list ->
                emit(list.map { it.toHabit() })
            }
    }

    override suspend fun add(habit: Habit): Result<Unit> {
        try {
            val time = timeProvider.currentTimeMillis()
            database.transaction {
                database.habitQueries.insertHabit(
                    title = habit.title,
                    category = habit.category.ordinal.toLong(),
                    is_completed = if (habit.isCompleted) 1L else 0L,
                    created_at = time,
                    updated_at = time
                )
            }
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
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

private fun Habit_table.toHabit(): Habit {
    return Habit(
        this.id.toString(),
        this.title,
        HabitCategory.entries[this.category.toInt()],
        this.is_completed == 1L,
        this.created_at.toString()
    )
}
