package com.example.greenspace.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light theme only. Each role below says where Material uses the colour.
private val GreenSpaceColorScheme = lightColorScheme(
    primary = MossGreen,
    onPrimary = Color.White,
    primaryContainer = PaleSage,
    onPrimaryContainer = DeepMoss,
    secondary = ClayPot,
    onSecondary = Color.White,
    secondaryContainer = PaleClay,
    onSecondaryContainer = SoilBrown,
    background = WarmCream,
    onBackground = SoilBrown,
    surface = WarmCream,
    onSurface = SoilBrown,
    surfaceVariant = PaleSage,
    onSurfaceVariant = DeepMoss,
    outline = SageLeaf
)

@Composable
fun GreenSpaceTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = GreenSpaceColorScheme,
        typography = Typography,
        content = content
    )
}