package ru.elkabelaya.ecotracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.compose.viewmodel.koinViewModel
import ru.elkabelaya.ecotracker.domain.model.Habit
import ru.elkabelaya.ecotracker.ui.screens.HabitScreen
import ru.elkabelaya.ecotracker.ui.screens.HomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Screen = Screen.Home
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.Home> {
            HomeScreen(koinViewModel(),
                {
                navController.navigate(Screen.AddHabit)
            }, {})

        }

        composable<Screen.AddHabit> {
            HabitScreen(
                habit = null,
                onAddClick = {
                    //
                },
                onBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}