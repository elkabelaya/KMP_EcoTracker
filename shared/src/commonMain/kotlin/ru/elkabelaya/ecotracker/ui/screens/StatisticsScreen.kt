package ru.elkabelaya.ecotracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.components.ActivityChart

@Composable
fun StatisticsScreen(
    weeklyData: List<Float> = listOf(5f, 8f, 12f, 7f, 15f, 10f, 18f),
    monthlyData: List<Float> = listOf(35f, 42f, 38f, 45f)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        androidx.compose.material3.Text(
            text = "Статистика",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
        )

        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.height(24.dp)
        )


        Text(
            text = "Активность за неделю",
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )

        ActivityChart(
            dataPoints = weeklyData,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        androidx.compose.foundation.layout.Spacer(
            modifier = Modifier.height(32.dp)
        )

        // График за месяц
        androidx.compose.material3.Text(
            text = "Активность за месяц",
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )

        ActivityChart(
            dataPoints = monthlyData,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
    }
}

@Preview
@Composable
fun StatisticsScreenPreview() {
    MaterialTheme {
        StatisticsScreen(listOf(1f, 3f, 7f), listOf(1f, 3f, 7f))
    }
}