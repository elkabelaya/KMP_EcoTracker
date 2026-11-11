package ru.elkabelaya.ecotracker.domain.model

data class Achievement(
    val id: String,
    val title: String,
    val description: String,
    val isUnlocked: Boolean,
    val progress: Float = 0f // 0.0 - 1.0
)
