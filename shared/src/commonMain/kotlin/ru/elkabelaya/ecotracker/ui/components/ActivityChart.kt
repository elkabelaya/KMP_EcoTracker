package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.multiplatform.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.multiplatform.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.multiplatform.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.multiplatform.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.multiplatform.cartesian.data.lineSeries
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.LineCartesianLayer
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.LineCartesianLayer.LineProvider.Companion.series
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.LineCartesianLayer.Point
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.LineCartesianLayer.PointProvider.Companion.single
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.rememberLine
import com.patrykandpatrick.vico.multiplatform.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.multiplatform.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.multiplatform.common.Fill
import com.patrykandpatrick.vico.multiplatform.common.component.rememberLineComponent
import com.patrykandpatrick.vico.multiplatform.common.component.rememberShapeComponent
import ru.elkabelaya.ecotracker.ui.theme.Dimens
@Suppress("MagicNumber")
@Composable
fun ActivityChart(
    dataPoints: List<Float>, // Значения активности за N дней
    modifier: Modifier = Modifier,
    lineColor: Color = Color(0xFF4CAF50),
    pointColor: Color = Color(0xFF81C784),
    showPoints: Boolean = true
) {
    if (dataPoints.isEmpty()) return

    // 1. Создаем и обновляем модель данных для Vico
    val modelProducer = remember { CartesianChartModelProducer() }
    LaunchedEffect(dataPoints) {
        if (dataPoints.isNotEmpty()) {
            modelProducer.runTransaction {
                lineSeries { series(dataPoints) }
            }
        }
    }

    // 2. Рендерим график
    CartesianChartHost(
        chart = rememberCartesianChart(
            rememberLineCartesianLayer(
                // Используем правильный lineProvider вместо устаревшего lineSpecs
                lineProvider = series(
                    LineCartesianLayer.rememberLine(
                        // Настройка цвета и заливки линии
                        fill = LineCartesianLayer.LineFill.single(Fill(lineColor)),
                        stroke = LineCartesianLayer.LineStroke.Continuous(thickness = Dimens.Thickness.l),
                        // Настройка точек (PointProvider)
                        pointProvider = if (showPoints) {
                            single(
                                Point(
                                    component = rememberShapeComponent(
                                        shape = CircleShape,
                                        fill = Fill(pointColor)
                                    ),
                                    size = 6.dp
                                )
                            )
                        } else {
                            null
                        }
                    )
                )
            ),
            // Левая (вертикальная) ось координат
            startAxis = VerticalAxis.rememberStart(
                line = rememberLineComponent(fill = Fill(Color.Gray), thickness = Dimens.Thickness.m),
                tick = null,
                guideline = rememberLineComponent(
                    fill = Fill(Color.LightGray.copy(alpha = 0.3f)),
                    thickness = Dimens.Thickness.s
                )
            ),
            // Нижняя (горизонтальная) ось координат
            bottomAxis = HorizontalAxis.rememberBottom(
                line = rememberLineComponent(fill = Fill(Color.Gray), thickness = Dimens.Thickness.m),
                tick = null,
                guideline = null
            )
        ),
        modelProducer = modelProducer,
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Preview
@Composable
private fun ActivityChartPreview() {
    MaterialTheme {
        ActivityChart(listOf(1f, 2f, 5f, 3f))
    }
}
