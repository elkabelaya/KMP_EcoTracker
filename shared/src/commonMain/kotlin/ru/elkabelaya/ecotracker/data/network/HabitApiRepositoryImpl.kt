package ru.elkabelaya.ecotracker.data.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.request.*
import io.ktor.http.*
import ru.elkabelaya.ecotracker.data.dto.HabitDto
import ru.elkabelaya.ecotracker.data.dto.HabitResponse
import ru.elkabelaya.ecotracker.data.dto.HabitsListResponse

class HabitApiRepositoryImpl(
    private val client: HttpClient
) : HabitApiRepository {

    override suspend fun getHabits(): Result<List<HabitDto>> = safeApiCall {
        val response = client.get("habits")
        response.body<HabitsListResponse>()
    }.map { it.data }

    override suspend fun createHabit(habit: HabitDto): Result<HabitDto> = safeApiCall {
        val response = client.post("habits") {
            setBody(habit)
        }
        response.body<HabitResponse>()
    }.map { it.data!! }

    override suspend fun updateHabit(id: String, habit: HabitDto): Result<HabitDto> = safeApiCall {
        val response = client.put("habits/$id") {
            setBody(habit)
        }
        response.body<HabitResponse>()
    }.map { it.data!! }

    override suspend fun deleteHabit(id: String): Result<Unit> = safeApiCall {
        client.delete("habits/$id")
        Unit
    }

    private inline fun <T> safeApiCall(block: () -> T): Result<T> {
        return try {
            val result = block()
            Result.success(result)
        } catch (e: SocketTimeoutException) {
            Result.failure(NetworkException("Нет интернета"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

class NetworkException(message: String) : Exception(message)