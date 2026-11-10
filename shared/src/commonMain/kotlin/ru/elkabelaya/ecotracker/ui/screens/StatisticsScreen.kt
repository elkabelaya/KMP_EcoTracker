package ru.elkabelaya.ecotracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.components.ActivityChart

@Composable
fun StatisticsScreen(
    weeklyData: List<Float> = listOf(5f, 8f, 12f, 7f, 15f, 10f, 18f),
    monthlyData: List<Float> = listOf(35f, 42f, 38f, 45f),
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Статистика") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }

                }
            )
        },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(
                    text = "Активность за неделю",
                    style = MaterialTheme.typography.titleMedium
                )

                ActivityChart(
                    dataPoints = weeklyData,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )

                Spacer(
                    modifier = Modifier.height(32.dp)
                )

                // График за месяц
                Text(
                    text = "Активность за месяц",
                    style = MaterialTheme.typography.titleMedium
                )

                ActivityChart(
                    dataPoints = monthlyData,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )
            }
        }
    )
}

@Preview
@Composable
fun StatisticsScreenPreview() {
    MaterialTheme {
        StatisticsScreen(listOf(1f, 3f, 7f), listOf(1f, 3f, 7f)) {}
    }
}