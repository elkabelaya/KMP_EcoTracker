package ru.elkabelaya.ecotracker.ui.navigation

import kotlinx.serialization.Serializable

@Serializable sealed class Screen {
    @Serializable object Home : Screen()
    @Serializable object AddHabit : Screen()
    @Serializable object Statistics: Screen()
}