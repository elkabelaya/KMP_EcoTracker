package ru.elkabelaya.ecotracker

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ru.elkabelaya.ecotracker.ui.navigation.AppNavHost
import ru.elkabelaya.ecotracker.ui.theme.Theme

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    Theme {
        AppNavHost(navController = navController)
    }
}
