package ru.elkabelaya.ecotracker.ui.theme

import androidx.compose.ui.unit.dp

/**
 * Central dimensions for the EcoTracker design system.
 * Values are sourced from the Figma component library.
 */
object Dimens {

    // ─── Paddings ────────────────────────────────────────────────────────────
    object Paddings {
        /** 8 dp — compact spacing */
        val xs = 4.dp
        val s = 8.dp

        /** 16 dp — standard card / screen content padding */
        val m = 16.dp
        val l = 24.dp
        val xl = 32.dp
    }

    // ─── Sizes (icons, avatars, thumb) ──────────────────────────────────────
    object Size {
        val xs = 16.dp
        val s = 24.dp

        /** 32 dp — settings row icons */
        val m = 32.dp

        /** 40 dp — habit / achievement card icon */
        val l = 40.dp

        /** 48 dp — nav icons base */
        val xl = 48.dp

        /** 56 dp — floating action button */
        val xxl = 56.dp
    }

    // ─── Component heights ───────────────────────────────────────────────────
    object Height {
        /** Switch track */
        val switch = 24.dp

        /** Text field (single line, no label) */
        val field = 48.dp

        /** Button: standard (Войти) */
        val buttonPrimary = 50.dp

        /** Button: secondary (Создать аккаунт) / danger (Выйти) */
        val buttonSecondary = 48.dp

        /** Button: prominent (Сохранить привычку) */
        val buttonProminent = 52.dp

        /** Habit card row */
        val habitCard = 64.dp

        /** Achievement card (compact) */
        val achievementCard = 72.dp

        /** Achievement card (with progress) */
        val achievementCardTall = 78.dp

        /** Achievement tile */
        val achievementTile = 85.dp

        /** Metric card */
        val metricCard = 82.5.dp

        /** Profile card */
        val profileCard = 92.dp

        /** Sync row */
        val syncRow = 59.dp

        /** Settings row */
        val settingsRow = 48.dp

        /** Bottom bar */
        val bottomBar = 69.dp

        /** Status bar */
        val statusBar = 24.dp
    }

    // ─── Corner radii ────────────────────────────────────────────────────────
    object Radius {
        val xs = 4.dp
        val s = 8.dp

        /** 12 dp — danger button, FAB form variant, settings icons, achievement tile form */
        val m = 12.dp

        /** 14 dp — primary / secondary buttons */
        val l = 14.dp

        /** 16 dp — habit card, achievement card, chart card, profile card, sync row */
        val xl = 16.dp

        /** 20 dp — prominent button (dark), achievement tile default */
        val xxl = 20.dp

        /** Full pill (switch, chips, badges) */
        val full = 9999.dp
    }

    // ─── Stroke / border widths ──────────────────────────────────────────────
    object Stroke {
        val thin = 1.dp
        val medium = 2.dp
    }

    // ─── Elevation (shadow blur radius) ──────────────────────────────────────
    object Elevation {
        /** Subtle card shadow (Form variant) */
        val low = 1.dp

        /** Prominent card / button glow */
        val medium = 4.dp
        val high = 8.dp
    }

    // ─── Misc ────────────────────────────────────────────────────────────────
    object Misc {
        /** Switch thumb size */
        val switchThumb = 16.dp

        /** Icon badge overlay on achievement tile */
        val tileIcon = 36.dp

        /** Small dot on achievement tile */
        val tileDot = 6.dp

        /** Avatar in sync row */
        val syncAvatar = 32.dp
    }

    object Thickness {
        val small = 1.dp
        val medium = 2.dp
        val large = 3.dp
    }

    object Percent {
        const val medium = 0.6f
    }
}
