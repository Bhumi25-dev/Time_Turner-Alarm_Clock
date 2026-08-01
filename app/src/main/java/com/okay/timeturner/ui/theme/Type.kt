package com.okay.timeturner.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ── Hogwarts Typography ──────────────────────────────────────────────────────
//
// Typography inspired by the enchanted books and scrolls of Hogwarts Library.
// FontFamily.Serif evokes the aged, hand-lettered manuscripts of the wizarding
// world — think Flourish and Blotts, the Daily Prophet, and Dumbledore's notes.
//
// Naming follows the magical hierarchy of Hogwarts:
//   displayLarge  → The Hogwarts Charter          (grand proclamations)
//   displayMedium → Ministry of Magic Decree       (official notices)
//   displaySmall  → Daily Prophet Headline         (news of the wizarding world)
//   headlineLarge → Chapter Heading (like Tom Riddle's diary chapters)
//   headlineMedium→ Section Heading (Quidditch match reports)
//   headlineSmall → Sub-heading    (Hogsmeade shop signs)
//   titleLarge    → Spell Name (Expecto Patronum)
//   titleMedium   → Potion Label   (Polyjuice Potion)
//   titleSmall    → Class Title    (Defence Against the Dark Arts)
//   bodyLarge     → Parchment Script – main reading (e.g., Hermione's notes)
//   bodyMedium    → Letter Script   (owl post correspondence)
//   bodySmall     → Margin Notes    (Snape's scribbled annotations)
//   labelLarge    → Button Spell Text (cast it!)
//   labelMedium   → Badge / Tag     (Prefect badge, house crest label)
//   labelSmall    → Fine Print      (Restricted Section disclaimer)

val HogwartsTypography = Typography(

    // ── Display – Grand proclamations & ancient texts ──────────────────────

    displayLarge = TextStyle(
        // The Hogwarts Charter – as grand as the castle itself
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Bold,
        fontSize     = 57.sp,
        lineHeight   = 64.sp,
        letterSpacing = (-0.25).sp,
    ),

    displayMedium = TextStyle(
        // Ministry of Magic Decree – authoritative, sweeping
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Bold,
        fontSize     = 45.sp,
        lineHeight   = 52.sp,
        letterSpacing = 0.sp,
    ),

    displaySmall = TextStyle(
        // Daily Prophet Headline – dramatic, attention-grabbing
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.SemiBold,
        fontSize     = 36.sp,
        lineHeight   = 44.sp,
        letterSpacing = 0.sp,
    ),

    // ── Headlines – Chapter titles & section markers ───────────────────────

    headlineLarge = TextStyle(
        // Chapter Heading – like chapters in Tom Riddle's diary
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.SemiBold,
        fontSize     = 32.sp,
        lineHeight   = 40.sp,
        letterSpacing = 0.sp,
    ),

    headlineMedium = TextStyle(
        // Quidditch Match Report heading
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.SemiBold,
        fontSize     = 28.sp,
        lineHeight   = 36.sp,
        letterSpacing = 0.sp,
    ),

    headlineSmall = TextStyle(
        // Hogsmeade shop signs
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Medium,
        fontSize     = 24.sp,
        lineHeight   = 32.sp,
        letterSpacing = 0.sp,
    ),

    // ── Titles – Spell names & potion labels ──────────────────────────────

    titleLarge = TextStyle(
        // Spell Name – spoken with authority (Expecto Patronum!)
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Bold,
        fontSize     = 22.sp,
        lineHeight   = 28.sp,
        letterSpacing = 0.sp,
    ),

    titleMedium = TextStyle(
        // Potion Label – precise, deliberate (Amortentia, Felix Felicis)
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Medium,
        fontSize     = 16.sp,
        lineHeight   = 24.sp,
        letterSpacing = 0.15.sp,
    ),

    titleSmall = TextStyle(
        // Class Title – neat and scholarly (Transfiguration, Charms)
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Medium,
        fontSize     = 14.sp,
        lineHeight   = 20.sp,
        letterSpacing = 0.1.sp,
    ),

    // ── Body – Parchment scrolls & owl post letters ───────────────────────

    bodyLarge = TextStyle(
        // Parchment Script – Hermione's meticulous study notes
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Normal,
        fontSize     = 16.sp,
        lineHeight   = 24.sp,
        letterSpacing = 0.5.sp,
    ),

    bodyMedium = TextStyle(
        // Letter Script – owl post between Harry and Sirius
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Normal,
        fontSize     = 14.sp,
        lineHeight   = 20.sp,
        letterSpacing = 0.25.sp,
    ),

    bodySmall = TextStyle(
        // Margin Notes – Snape's scribbled Half-Blood Prince annotations
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Light,
        fontSize     = 12.sp,
        lineHeight   = 16.sp,
        letterSpacing = 0.4.sp,
    ),

    // ── Labels – Badges, buttons & fine print ─────────────────────────────

    labelLarge = TextStyle(
        // Button Spell Text – cast it with confidence!
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.SemiBold,
        fontSize     = 14.sp,
        lineHeight   = 20.sp,
        letterSpacing = 0.1.sp,
    ),

    labelMedium = TextStyle(
        // Badge / House Crest Label – Prefect, Head Boy, Quidditch Captain
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Medium,
        fontSize     = 12.sp,
        lineHeight   = 16.sp,
        letterSpacing = 0.5.sp,
    ),

    labelSmall = TextStyle(
        // Fine Print – Restricted Section disclaimer & potion warnings
        fontFamily   = FontFamily.Serif,
        fontWeight   = FontWeight.Normal,
        fontSize     = 11.sp,
        lineHeight   = 16.sp,
        letterSpacing = 0.5.sp,
    ),
)

// Legacy alias so any existing references to `Typography` still compile
val Typography = HogwartsTypography