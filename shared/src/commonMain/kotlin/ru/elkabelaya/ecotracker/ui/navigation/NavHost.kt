package ru.elkabelaya.ecotracker.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.compose.viewmodel.koinViewModel
import ru.elkabelaya.ecotracker.ui.screens.HabitScreen
import ru.elkabelaya.ecotracker.ui.screens.HomeScreen
import ru.elkabelaya.ecotracker.ui.screens.StatisticsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Screen = Screen.Home
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            enterTransition()
        },
        exitTransition = {
            exitTransition()
        },
        popEnterTransition = {
            popEnterTransition()
        },
        popExitTransition = {
            popExitTransition()
        }
    ) {
        composable<Screen.Home> {
            HomeScreen(koinViewModel(),
                {
                navController.navigate(Screen.AddHabit)
            },
                {},
                {
                    navController.navigate(Screen.Statistics)
                }
            )

        }

        composable<Screen.AddHabit> {
            HabitScreen(
                koinViewModel(),
                onBack = {
                    navController.navigateUp()
                }
            )
        }

        composable<Screen.Statistics> {
            StatisticsScreen(
                onBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}

private const val ANIMATION_DURATION = 300
private val intTween: FiniteAnimationSpec<IntOffset> = tween(durationMillis = ANIMATION_DURATION)
private val floatTween: FiniteAnimationSpec<Float> = tween(durationMillis = ANIMATION_DURATION)
private fun AnimatedContentTransitionScope<NavBackStackEntry>.enterTransition(): EnterTransition {
    return slideIntoContainer(
        AnimatedContentTransitionScope.SlideDirection.Left,
        intTween
    ) + fadeIn(floatTween)
}

private fun AnimatedContentTransitionScope<NavBackStackEntry>.exitTransition(): ExitTransition {
    return ExitTransition.None + fadeOut(floatTween)
}

private fun AnimatedContentTransitionScope<NavBackStackEntry>.popEnterTransition(): EnterTransition {
    return EnterTransition.None + fadeIn(floatTween)
}

private fun AnimatedContentTransitionScope<NavBackStackEntry>.popExitTransition(): ExitTransition {
    return slideOutOfContainer(
        AnimatedContentTransitionScope.SlideDirection.Right,
        intTween
    ) + fadeOut(floatTween)
}