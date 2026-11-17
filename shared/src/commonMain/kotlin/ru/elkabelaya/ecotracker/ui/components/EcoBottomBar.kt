package ru.elkabelaya.ecotracker.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import ru.elkabelaya.ecotracker.ui.extensions.AppPreview
import ru.elkabelaya.ecotracker.ui.theme.EcoTrackTheme

/**
 * Bottom navigation bar with 3 tabs.
 *
 * Figma: `EcoTrack / Navigation / Bottom bar`
 * - 346×69, bg surface
 * - Each tab: icon 34×34 in rounded-12 container + label (Caption 10 Medium)
 * - Active: icon bg = primary, icon = onPrimary, label = onSurface
 * - Inactive: icon outline, icon = onSurfaceVariant, label = onSurfaceVariant
 */

/**
 * @param tabs the list of navigation tabs (typically 3).
 * @param selectedIndex index of the currently selected tab.
 * @param onTabClick callback with the tapped tab index.
 */
@Composable
fun EcoBottomBar(
    tabs: List<EcoNavTab>,
    selectedIndex: Int,
    onTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    SecondaryTabRow(
        selectedTabIndex = selectedIndex,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        divider = { HorizontalDivider() }
    ) {
        tabs.forEachIndexed { index, item ->
            Tab(
                selected = (selectedIndex == index),
                onClick = { onTabClick(index) },
                text = {
                    Text(
                        text = item.label,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleSmall
                    )
                },
               icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                }
            )
        }
    }
}

@AppPreview
@Composable
private fun EcoBottomBarPreview() {
    EcoTrackTheme {
        EcoBottomBar(
            tabs = listOf(
                EcoNavTab("Домой", Icons.Default.Cloud),
                EcoNavTab("Активность", Icons.Default.Cloud),
                EcoNavTab("Профиль", Icons.Default.Cloud),
            ),
            selectedIndex = 0,
            onTabClick = {},
        )
    }
}
