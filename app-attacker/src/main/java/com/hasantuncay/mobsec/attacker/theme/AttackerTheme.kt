package com.hasantuncay.mobsec.attacker.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val AttackerBackground = Color(0xFF0A0A0A)
val AttackerSurface    = Color(0xFF111111)
val AttackerRed        = Color(0xFFFF1744)
val AttackerRedDim     = Color(0xFF7F0022)
val AttackerGreen      = Color(0xFF00FF41)  // "Matrix green"
val AttackerYellow     = Color(0xFFFFD600)
val AttackerText       = Color(0xFFE0E0E0)
val AttackerTextDim    = Color(0xFF757575)
val AttackerCard       = Color(0xFF1A1A1A)

private val AttackerColorScheme = darkColorScheme(
    primary         = AttackerRed,
    onPrimary       = Color.White,
    secondary       = AttackerRedDim,
    background      = AttackerBackground,
    surface         = AttackerSurface,
    onSurface       = AttackerText,
    onSurfaceVariant = AttackerTextDim,
    error           = AttackerRed,
    errorContainer  = Color(0xFF3D0014),
    onErrorContainer = AttackerRed
)

@Composable
fun AttackerTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AttackerColorScheme,
        content = content
    )
}
