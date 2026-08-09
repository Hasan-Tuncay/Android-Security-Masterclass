package com.hasantuncay.mobsec.common.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hasantuncay.mobsec.common.models.MasweItem
import com.hasantuncay.mobsec.common.models.MasweScreenMeta
import kotlinx.coroutines.launch

/**
 * Rendering mode for the unified MASWE screen.
 * Controls color theming, labels, and visual cues.
 */
enum class ScreenMode {
    VULNERABLE, SECURE
}

/**
 * Unified base screen for both Vulnerable and Secure MASWE demonstrations.
 * Eliminates ~210 lines of duplicated code between the old BaseVulnerableScreen/BaseSecureScreen.
 *
 * @param mode      Determines color scheme (error-themed vs primary-themed) and labels.
 * @param meta      Screen-level metadata (masweId, title, description, etc.).
 * @param items     List of MasweItem entries (vectors or mitigations).
 * @param onBack    Navigation callback.
 * @param onItemClicked  Optional suspend lambda invoked when an item button is tapped.
 * @param content   Optional trailing composable content.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : MasweItem> BaseMasweScreen(
    mode: ScreenMode,
    meta: MasweScreenMeta,
    items: List<T>,
    onBack: () -> Unit,
    onItemClicked: (suspend (T) -> String?)? = null,
    content: @Composable (ColumnScope.() -> Unit)? = null
) {
    if (items.isEmpty()) return

    val masweId = meta.masweId
    val titleString = stringResource(id = meta.titleRes)
    val displayDesc = stringResource(id = meta.descRes)
    val contextInfoRes = meta.contextInfoRes
    val itemsTitle = stringResource(id = meta.itemsTitleRes)

    // Theme colors based on mode
    val headerContainerColor = when (mode) {
        ScreenMode.VULNERABLE -> MaterialTheme.colorScheme.errorContainer
        ScreenMode.SECURE -> MaterialTheme.colorScheme.primaryContainer
    }
    val headerContentColor = when (mode) {
        ScreenMode.VULNERABLE -> MaterialTheme.colorScheme.onErrorContainer
        ScreenMode.SECURE -> MaterialTheme.colorScheme.onPrimaryContainer
    }
    val iconTint = when (mode) {
        ScreenMode.VULNERABLE -> MaterialTheme.colorScheme.error
        ScreenMode.SECURE -> MaterialTheme.colorScheme.primary
    }
    val modeLabel = when (mode) {
        ScreenMode.VULNERABLE -> "VULNERABLE"
        ScreenMode.SECURE -> "SECURE"
    }

    val coroutineScope = rememberCoroutineScope()
    var lastResultPath by remember { mutableStateOf<String?>(null) }
    var lastTriggeredItem by remember { mutableStateOf<T?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("$masweId ($modeLabel)") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header card
            Card(
                colors = CardDefaults.cardColors(containerColor = headerContainerColor),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = masweId,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = headerContentColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = titleString,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = headerContentColor
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = displayDesc,
                        style = MaterialTheme.typography.bodyMedium,
                        color = headerContentColor
                    )
                }
            }

            // Context info card (optional)
            if (contextInfoRes != null) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = contextInfoRes),
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            HorizontalDivider()
            Text(
                text = itemsTitle,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            // Item list
            items.forEach { item ->
                if (onItemClicked != null) {
                    InteractiveVectorButton(
                        title = stringResource(id = item.titleRes),
                        icon = item.icon,
                        isActive = lastTriggeredItem == item,
                        onClick = {
                            lastTriggeredItem = item
                            lastResultPath = null
                            coroutineScope.launch {
                                lastResultPath = onItemClicked(item)
                            }
                        }
                    )
                } else {
                    // Static representation
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                tint = iconTint
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = stringResource(id = item.titleRes),
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = stringResource(id = item.msgRes),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }

            // Result card animation
            if (onItemClicked != null) {
                AnimatedVisibility(
                    visible = lastTriggeredItem != null,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    lastTriggeredItem?.let { item ->
                        InteractiveResultCard(
                            resultPath = lastResultPath,
                            adbCommand = item.getAdbCommand(lastResultPath),
                            isSecure = mode == ScreenMode.SECURE,
                            messageText = stringResource(id = item.msgRes)
                        )
                    }
                }
            }

            // Placeholder or custom content
            if (content == null && onItemClicked == null) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Construction,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "Full implementations for $masweId are under development.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                }
            } else if (content != null) {
                content()
            }
        }
    }
}
