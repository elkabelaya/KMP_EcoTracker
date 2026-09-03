package ru.elkabelaya.ecotracker

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.elkabelaya.ecotracker.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "EcoTracker",
    ) {
        App()
    }
}