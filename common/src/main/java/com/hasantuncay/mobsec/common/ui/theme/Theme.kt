package com.hasantuncay.mobsec.common.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class AppType {
    VULNERABLE,
    SECURE
}

private val VulnDarkColorScheme = darkColorScheme(
    primary = VulnPrimaryDark,
    primaryContainer = Color(0xFF93000A), // Dark Red
    secondary = VulnSecondaryDark,
    tertiary = VulnTertiaryDark,
    background = VulnBackgroundDark,
    surface = VulnSurfaceDark,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val VulnLightColorScheme = lightColorScheme(
    primary = VulnPrimaryLight,
    primaryContainer = Color(0xFFFFDAD6), // Light Red
    secondary = VulnSecondaryLight,
    tertiary = VulnTertiaryLight,
    background = VulnBackgroundLight,
    surface = VulnSurfaceLight,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val SecureDarkColorScheme = darkColorScheme(
    primary = SecurePrimaryDark,
    primaryContainer = Color(0xFF00497D), // Dark Blue
    secondary = SecureSecondaryDark,
    tertiary = SecureTertiaryDark,
    background = SecureBackgroundDark,
    surface = SecureSurfaceDark,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val SecureLightColorScheme = lightColorScheme(
    primary = SecurePrimaryLight,
    primaryContainer = Color(0xFFD1E4FF), // Light Blue
    secondary = SecureSecondaryLight,
    tertiary = SecureTertiaryLight,
    background = SecureBackgroundLight,
    surface = SecureSurfaceLight,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun AndroidSecurityMasterclassTheme(
    appType: AppType,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // We intentionally disable dynamicColor to enforce our psychological color schemes
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when (appType) {
        AppType.VULNERABLE -> if (darkTheme) VulnDarkColorScheme else VulnLightColorScheme
        AppType.SECURE -> if (darkTheme) SecureDarkColorScheme else SecureLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}