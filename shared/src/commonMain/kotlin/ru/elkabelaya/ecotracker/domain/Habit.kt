package ru.elkabelaya.ecotracker.domain

data class Habit(
    val id: String,
    val title: String,
    val category: String, // "Транспорт", "Мусор"
    val isCompleted: Boolean = false,
    val date: String // Формат "24.10"
)

typealias Habits = List<Habit>