package ru.elkabelaya.ecotracker.ui.extensions

import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_TYPE_NORMAL
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL)
@Preview(device = "spec:width=360dp,height=640dp,dpi=240", name = "Small Vertical")
@Preview(device = "spec:width=600dp,height=900dp,dpi=240", name = "Medium Vertical")
@Preview(device = "spec:width=900dp,height=600dp,dpi=240", name = "Medium Horizontal")
@Preview(device = "spec:width=840dp,height=1200dp,dpi=240", name = "Large Vertical")
@Preview(device = "spec:width=1200dp,height=840dp,dpi=240", name = "Large Horizontal")
annotation class AppPreview
