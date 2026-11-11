package ru.elkabelaya.ecotracker.data.repository

import kotlinx.coroutines.flow.Flow
import ru.elkabelaya.ecotracker.data.dto.HabitDto
import ru.elkabelaya.ecotracker.data.network.HabitApiRepository
import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.domain.model.HabitCategory
import ru.elkabelaya.ecotracker.domain.model.Habits
import ru.elkabelaya.ecotracker.domain.repository.HabitRepository

@Suppress("TooGenericExceptionCaught")
class HabitSyncRepository(
    private val localRepo: HabitRepository,
    private val apiRepo: HabitApiRepository
) : HabitRepository {

    override fun getHabits(): Flow<Habits> {
        return localRepo.getHabits()
    }

    override suspend fun add(habit: Habit): Result<Unit> {
        val localResult = localRepo.add(habit)

        if (localResult.isFailure) {
            return localResult.map { }
        }

        val dto = habit.toDto()
        apiRepo.createHabit(dto).onFailure {
        }

        return localResult.map { }
    }

    override suspend fun update(habit: Habit): Result<Unit> {
        val localResult = localRepo.update(habit)

        if (localResult.isFailure) {
            return localResult.map { }
        }

        val dto = habit.toDto()
        apiRepo.updateHabit(habit.id, dto).onFailure { }

        return localResult.map { }
    }

    override suspend fun delete(id: String): Result<Unit> {
        val localResult = localRepo.delete(id)

        if (localResult.isFailure) {
            return localResult
        }

        apiRepo.deleteHabit(id).onFailure { }

        return localResult
    }

    override suspend fun getByCategory(category: HabitCategory): Flow<Habits> {
        return localRepo.getByCategory(category)
    }

    suspend fun syncWithServer(): Result<Unit> {
        return try {
            val remoteHabits = apiRepo.getHabits()

            if (remoteHabits.isSuccess) {
                // Очищаем локальную БД и загружаем с сервера
                remoteHabits.getOrNull()?.forEach { dto ->
                    localRepo.add(dto.toDomainEntity())
                }
            }

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

private fun Habit.toDto(): HabitDto =
    HabitDto(
        id = this.id,
        title = this.title,
        category = this.category.toString(),
        isCompleted = this.isCompleted,
        createdAt = 1L,
        updatedAt = 1L
    )

private fun HabitDto.toDomainEntity(): Habit =
    Habit(
        id = this.id,
        title = this.title,
        category = HabitCategory.valueOf(this.category),
        isCompleted = this.isCompleted,
    )
