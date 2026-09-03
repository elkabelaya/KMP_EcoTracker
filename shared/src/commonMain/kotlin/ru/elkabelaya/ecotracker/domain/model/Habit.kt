package ru.elkabelaya.ecotracker.domain.model

data class Habit(
    val id: String,
    val title: String,
    val category: HabitCategory,
    val isCompleted: Boolean = false,
    val date: String? = null
)

typealias Habits = List<Habit>