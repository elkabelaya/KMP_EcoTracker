package ru.elkabelaya.ecotracker

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ru.elkabelaya.ecotracker.di.initKoin
import ru.elkabelaya.ecotracker.di.initKoinWeb

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    MainScope().launch {
        initKoinWeb()
        ComposeViewport {
            App()
        }
    }
}