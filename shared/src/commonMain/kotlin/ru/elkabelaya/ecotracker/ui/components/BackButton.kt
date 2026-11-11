package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import ecotracker.shared.generated.resources.Res
import ecotracker.shared.generated.resources.components_back_button_accessability
import ru.elkabelaya.ecotracker.ui.extensions.Icon

@Composable
fun BackButton(onBack: () -> Unit) {
    IconButton(onClick = onBack) {
        Icon(
            imageVector = Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = Res.string.components_back_button_accessability
        )
    }
}
