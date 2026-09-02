package ru.elkabelaya.ecotracker.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.elkabelaya.ecotracker.domain.Habit
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
            HomeScreen(listOf(Habit("1", "", "", false, "")),{
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