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
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hasantuncay.mobsec.common.models.MasweMitigation
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : MasweMitigation> BaseSecureScreen(
    vectors: List<T>,
    onBack: () -> Unit,
    onVectorClicked: (suspend (T) -> String?)? = null,
    content: @Composable (ColumnScope.() -> Unit)? = null
) {
    if (vectors.isEmpty()) return

    val sampleVector = vectors.first()
    val masweId = sampleVector.masweId
    val titleString = stringResource(id = sampleVector.screenTitleSecureRes)
    val displayDesc = stringResource(id = sampleVector.screenDescSecureRes)
    val contextInfoRes = sampleVector.contextInfoRes
    val vectorsTitle = stringResource(id = sampleVector.vectorsTitleSecureRes)

    val coroutineScope = rememberCoroutineScope()
    var lastResultPath by remember { mutableStateOf<String?>(null) }
    var lastTriggeredVector by remember { mutableStateOf<T?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("$masweId (SECURE)") },
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
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "$masweId — Secure Mitigations",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = titleString,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = displayDesc,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

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
                text = vectorsTitle,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            vectors.forEach { vector ->
                if (onVectorClicked != null) {
                    InteractiveVectorButton(
                        title = stringResource(id = vector.titleSecureRes),
                        icon = Icons.Default.Shield,
                        isActive = lastTriggeredVector == vector,
                        onClick = {
                            lastTriggeredVector = vector
                            lastResultPath = null
                            coroutineScope.launch {
                                lastResultPath = onVectorClicked(vector)
                            }
                        }
                    )
                } else {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Shield,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = stringResource(id = vector.titleSecureRes),
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = stringResource(id = vector.msgSecureRes),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }

            if (onVectorClicked != null) {
                AnimatedVisibility(
                    visible = lastTriggeredVector != null,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    lastTriggeredVector?.let { vector ->
                        InteractiveResultCard(
                            resultPath = lastResultPath,
                            adbCommand = vector.getAdbCommandSecure(lastResultPath),
                            isSecure = true,
                            messageText = stringResource(id = vector.msgSecureRes)
                        )
                    }
                }
            }

            if (content == null && onVectorClicked == null) {
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
                            text = "Full secure implementations for $masweId are under development.",
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
