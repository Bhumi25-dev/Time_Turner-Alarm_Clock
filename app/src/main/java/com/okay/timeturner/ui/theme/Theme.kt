package com.okay.timeturner.ui.theme

import android.app.Activity
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// ── Harry Potter Dark Color Scheme ──────────────────────────────────────────
//
// "It is our choices, Harry, that show what we truly are,
//  far more than our abilities." — Albus Dumbledore
//
// This theme is always dark — like a castle at midnight under a moonless sky.
// Dynamic color is disabled to preserve the magical Hogwarts aesthetic.

private val HogwartsDarkColorScheme = darkColorScheme(
    // ── Primary – Gryffindor Scarlet ──────────────────────────────────────
    primary            = GryffindorScarlet,
    onPrimary          = ParchmentWhite,
    primaryContainer   = Color(0xFF5A0001),   // Deeper scarlet container
    onPrimaryContainer = GryffindorGold,

    // ── Secondary – Slytherin Green ───────────────────────────────────────
    secondary            = SlytherInGreenLight,
    onSecondary          = ParchmentWhite,
    secondaryContainer   = SlytherInGreen,
    onSecondaryContainer = ParchmentCream,

    // ── Tertiary – Magical Purple (spells & enchantments) ─────────────────
    tertiary            = MagicPurpleLight,
    onTertiary          = ParchmentWhite,
    tertiaryContainer   = MagicPurple,
    onTertiaryContainer = WandlightAmber,

    // ── Backgrounds – Hogwarts at midnight ───────────────────────────────
    background    = MidnightBlack,
    onBackground  = ParchmentWhite,
    surface       = HogwartsDark,
    onSurface     = ParchmentCream,

    // ── Surface variants – Dungeon stone & torchlit corridors ─────────────
    surfaceVariant   = DungeonStone,
    onSurfaceVariant = QuillInk,
    surfaceTint      = GryffindorScarlet,

    // ── Outlines – Crumbling castle walls ─────────────────────────────────
    outline        = RavenclawBronze,
    outlineVariant = FadedInk,

    // ── Status ────────────────────────────────────────────────────────────
    error          = ErrorRed,
    onError        = MidnightBlack,
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),

    // ── Inverse – Mirror of Erised effect ─────────────────────────────────
    inverseSurface    = ParchmentCream,
    inverseOnSurface  = HogwartsDark,
    inversePrimary    = GryffindorScarlet,

    // ── Scrim & container extras ──────────────────────────────────────────
    scrim = MidnightBlack,
)

@Composable
fun TimeTurnerTheme(
    // The Wizarding World is always cloaked in darkness — force dark theme
    darkTheme: Boolean = true,
    // Dynamic color disabled: let the magic of Hogwarts shine through
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    // The castle walls never change their colours
    val colorScheme = HogwartsDarkColorScheme

    // Make the system status bar part of the Hogwarts sky
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            @Suppress("DEPRECATION")
            window.statusBarColor = MidnightBlack.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = HogwartsTypography,
        content     = content
    )
}