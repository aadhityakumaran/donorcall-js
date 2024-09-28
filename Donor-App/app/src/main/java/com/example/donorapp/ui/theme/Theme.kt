package com.example.donorapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFC62828), // Red 700
    secondary = Color(0xFFEF9A9A), // Light Red
    tertiary = Color(0xFFB2DFDB), // Teal 100
    background = Color(0xFF121212), // Dark background for dark theme
    surface = Color(0xFF1F1F1F), // Dark surface
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFC62828), // Red 700
    secondary = Color(0xFFEF9A9A), // Light Red
    tertiary = Color(0xFFB2DFDB), // Teal 100
    background = Color(0xFFFFFFFF), // White background
    surface = Color(0xFFF5F5F5), // Light gray surface
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color(0xFF212121), // Dark text on light background
    onSurface = Color(0xFF212121) // Dark text on light surface
)

@Composable
fun DonorAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}