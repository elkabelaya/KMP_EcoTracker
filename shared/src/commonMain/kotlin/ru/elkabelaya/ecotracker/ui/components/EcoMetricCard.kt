package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.Dimens
import ru.elkabelaya.ecotracker.ui.theme.EcoCaptionRegular8
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * Small metric / stat card for grid layouts (e.g. "Стreak: 5", "Total: 42", "Rating: A").
 *
 * Figma: `EcoTrack / Cards / Metric`
 * - ~110×82, bg surface, radius 16 dp
 * - Large value (Heading 22 Bold, colored)
 * - Label (Caption 10 SemiBold, onSurfaceVariant)
 * - Optional caption (Caption 8 Regular)
 *
 * @param value the prominent number/text (e.g. "5", "42", "A+").
 * @param label the metric name (e.g. "Стreak", "Всего", "Рейтинг").
 * @param caption optional sub-label (e.g. "дней подряд").
 * @param valueColor the accent color for the value.
 */
@Composable
fun EcoMetricCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    caption: String? = null,
    valueColor: Color = MaterialTheme.colorScheme.primary,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(Dimens.Radius.xl))
            .background(MaterialTheme.colorScheme.surface)
            .padding(Dimens.Paddings.m),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Value
        Text(
            text = value,
            style = MaterialTheme.typography.headlineLarge,
            color = valueColor,
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(4.dp))

        // Label
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )

        // Optional caption
        if (caption != null) {
            Spacer(Modifier.height(2.dp))
            Text(
                text = caption,
                style = EcoCaptionRegular8,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@AppPreview
@Composable
private fun EcoMetricCardPreview() {
    EcoTrackTheme {
        Row {
            EcoMetricCard("5", "Стрик", caption = "дней подряд")
            Spacer(Modifier.size(12.dp))
            EcoMetricCard("42", "Всего")
            Spacer(Modifier.size(12.dp))
            EcoMetricCard("A+", "Рейтинг", valueColor = MaterialTheme.colorScheme.primary)
        }
    }
}
