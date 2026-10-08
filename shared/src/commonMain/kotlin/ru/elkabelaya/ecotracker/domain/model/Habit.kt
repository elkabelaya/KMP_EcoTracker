package ru.elkabelaya.ecotracker.domain.model

data class Habit(
    val id: String,
    val title: String,
    val category: HabitCategory,
    val isCompleted: Boolean = false,
    val date: String? = null ) {
    companion object {
        fun emptyHabit(): Habit {
            return Habit("", "", HabitCategory.TRANSPORT)
        }
    }
}


typealias Habits = List<Habit>