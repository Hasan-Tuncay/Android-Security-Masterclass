package com.hasantuncay.mobsec.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasantuncay.mobsec.common.R

@Composable
fun InteractiveVectorButton(
    title: String,
    icon: ImageVector,
    isActive: Boolean,
    onClick: () -> Unit,
    isSecure: Boolean = false,
    modifier: Modifier = Modifier
) {
    if (isSecure) {
        val containerColor = if (isActive) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
        val contentColor = if (isActive) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface

        ElevatedCard(
            onClick = onClick,
            colors = CardDefaults.elevatedCardColors(containerColor = containerColor, contentColor = contentColor),
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    } else {
        Button(
            onClick = onClick,
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isActive)
                    MaterialTheme.colorScheme.error
                else
                    MaterialTheme.colorScheme.secondary
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = if (isActive) Icons.Default.BugReport else icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = title, fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Composable
fun InteractiveResultCard(
    resultPath: String?,
    adbCommand: String,
    isSecure: Boolean = false,
    loadingText: String = stringResource(R.string.label_processing),
    pathLabel: String = stringResource(R.string.label_path_verification),
    triggeredText: String = if (isSecure) stringResource(R.string.label_defense_activated) else stringResource(R.string.label_vector_triggered),
    messageText: String? = null
) {
    val containerColor = if (isSecure) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer
    val onContainerColor = if (isSecure) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onErrorContainer
    val mainColor = if (isSecure) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
    val checkIcon = if (isSecure) Icons.Default.Shield else Icons.Default.CheckCircle
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = checkIcon,
                    contentDescription = null,
                    tint = mainColor,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = triggeredText,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = onContainerColor
                )
            }

            if (messageText != null) {
                Text(
                    text = messageText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = onContainerColor
                )
            }

            HorizontalDivider(color = mainColor.copy(alpha = 0.3f))

            // Written path / URI
            if (resultPath != null) {
                Text(
                    text = pathLabel,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = onContainerColor
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.surface.copy(alpha = 0.6f),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(10.dp)
                ) {
                    Text(
                        text = resultPath,
                        style = MaterialTheme.typography.bodySmall,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        color = mainColor
                    )
                }
            } else {
                // Loading state
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = mainColor)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = loadingText,
                        style = MaterialTheme.typography.bodySmall,
                        color = onContainerColor
                    )
                }
            }

            // ADB verification command
            HorizontalDivider(color = mainColor.copy(alpha = 0.3f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Terminal,
                    contentDescription = null,
                    tint = onContainerColor,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = if (isSecure) stringResource(R.string.label_adb_verification_secure) else stringResource(R.string.label_adb_verification),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = onContainerColor
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.surface.copy(alpha = 0.6f),
                        RoundedCornerShape(8.dp)
                    )
                    .padding(10.dp)
            ) {
                Text(
                    text = adbCommand,
                    style = MaterialTheme.typography.bodySmall,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    lineHeight = 16.sp
                )
            }
        }
    }
}
