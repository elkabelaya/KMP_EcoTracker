package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoCaptionRegular
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * Activity chart card — wraps the weekly activity chart with a title,
 * subtitle and a trend badge.
 *
 * Figma: `EcoTrack / Charts / Activity`
 * - 346×163 (compact) or 346×185 (with legend), bg surface, radius 16 dp
 * - Header: title (Body 14 SemiBold) + subtitle (Caption 10 Regular)
 * - Right: trend badge pill (e.g. "+12%" green)
 * - Body: the actual chart (provided via [chartContent] slot)
 *
 * @param chartContent composable slot for the bar/line chart body.
 * @param trendText e.g. "+12%" or "−5%".
 * @param isPositive whether the trend is positive (green) or negative (red).
 */
@Composable
fun EcoActivityChartCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    trendText: String? = null,
    isPositive: Boolean = true,
    chartContent: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.Radius.xl))
            .background(MaterialTheme.colorScheme.surface)
            .shadow(
                elevation = Dimens.Elevation.low,
                shape = RoundedCornerShape(Dimens.Radius.xl)
            )
            .padding(Dimens.Paddings.m),
    ) {
        // Header row
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    style = EcoCaptionRegular,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }

            // Trend badge
            if (trendText != null) {
                val trendColor = if (isPositive) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.error
                }
                Text(
                    text = trendText,
                    style = MaterialTheme.typography.bodySmall,
                    color = trendColor,
                    modifier = Modifier
                        .background(
                            color = trendColor.copy(alpha = 0.12f),
                            shape = RoundedCornerShape(Dimens.Radius.full)
                        )
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(Modifier.height(Dimens.Paddings.m))

        // Chart body
        chartContent()
    }
}

@AppPreview
@Composable
private fun EcoActivityChartCardPreview() {
    EcoTrackTheme {
        EcoActivityChartCard(
            title = "Активность",
            subtitle = "За эту неделю",
            trendText = "+12%",
            chartContent = {
                // Placeholder chart area
                Spacer(Modifier.height(80.dp))
            },
        )
    }
}
