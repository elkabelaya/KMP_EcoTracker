package ru.elkabelaya.ecotracker.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class HabitDto(
    val id: String,
    val title: String,
    val category: String,
    val isCompleted: Boolean,
    val createdAt: Long,
    val updatedAt: Long
)

@Serializable
data class HabitResponse(
    val success: Boolean,
    val data: HabitDto? = null,
    val error: String? = null
)

@Serializable
data class HabitsListResponse(
    val success: Boolean,
    val data: List<HabitDto> = emptyList(),
    val error: String? = null
)
