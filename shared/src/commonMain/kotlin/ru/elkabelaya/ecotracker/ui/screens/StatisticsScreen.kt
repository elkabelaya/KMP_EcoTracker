package ru.elkabelaya.ecotracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ecotracker.shared.generated.resources.Res
import ecotracker.shared.generated.resources.statistics_month
import ecotracker.shared.generated.resources.statistics_title
import ecotracker.shared.generated.resources.statistics_weak
import ru.elkabelaya.ecotracker.ui.components.ActivityChart
import ru.elkabelaya.ecotracker.ui.components.BackButton
import ru.elkabelaya.ecotracker.ui.extensions.Text
import ru.elkabelaya.ecotracker.ui.theme.Dimens

@Suppress("MagicNumber")
@Composable
fun StatisticsScreen(
    weeklyData: List<Float> = listOf(5f, 8f, 12f, 7f, 15f, 10f, 18f),
    monthlyData: List<Float> = listOf(35f, 42f, 38f, 45f),
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        Res.string.statistics_title,
                        style = MaterialTheme.typography.titleMedium
                    )
                        },
                navigationIcon = { BackButton(onBack = onBack) }
            )
        },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Text(
                    Res.string.statistics_weak,
                    style = MaterialTheme.typography.titleMedium
                )

                ActivityChart(
                    dataPoints = weeklyData,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Dimens.Paddings.m)
                )

                Spacer(
                    modifier = Modifier.height(Dimens.Size.l)
                )

                // График за месяц
                Text(
                    Res.string.statistics_month,
                    style = MaterialTheme.typography.titleMedium
                )

                ActivityChart(
                    dataPoints = monthlyData,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Dimens.Paddings.m)
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
