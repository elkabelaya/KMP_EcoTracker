package ru.elkabelaya.ecotracker

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource

import ecotracker.shared.generated.resources.Res
import ecotracker.shared.generated.resources.compose_multiplatform
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