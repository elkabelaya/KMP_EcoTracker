package ru.elkabelaya.ecotracker

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.viewmodel.koinViewModel
import ru.elkabelaya.ecotracker.ui.navigation.AppNavHost
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme
import ru.elkabelaya.ecotracker.ui.viewmodels.AppViewModel

@Composable
@Suppress("UnusedParameter")
fun App(viewModel: AppViewModel = koinViewModel()) {
    val navController = rememberNavController()

    EcoTrackTheme {
        AppNavHost(navController = navController)
    }
}
