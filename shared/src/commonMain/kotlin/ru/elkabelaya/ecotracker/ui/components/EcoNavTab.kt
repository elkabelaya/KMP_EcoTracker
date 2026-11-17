package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.ui.graphics.vector.ImageVector

data class EcoNavTab(
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector? = null,
)
