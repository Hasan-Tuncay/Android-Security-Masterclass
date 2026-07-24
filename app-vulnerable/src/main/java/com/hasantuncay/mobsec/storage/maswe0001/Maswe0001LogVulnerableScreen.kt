package com.hasantuncay.mobsec.storage.maswe0001

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.hasantuncay.mobsec.common.R
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.hasantuncay.mobsec.common.models.data.LocalMasterclassViewModel
import com.hasantuncay.mobsec.common.models.Maswe0001Vector

import com.hasantuncay.mobsec.common.ui.components.AnalyticsLogCard
import com.hasantuncay.mobsec.common.ui.components.GdprPiiCard
import com.hasantuncay.mobsec.common.ui.components.PciDssCard
import com.hasantuncay.mobsec.common.ui.components.SessionDataCard
import com.hasantuncay.mobsec.common.ui.components.UserDataCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0001LogVulnerableScreen(onBack: () -> Unit) {
    val viewModel = LocalMasterclassViewModel.current
    val appData by viewModel.masterclassData.collectAsState()
    
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    var lastResultPath by remember { mutableStateOf<String?>(null) }
    var lastTriggeredVector by remember { mutableStateOf<Maswe0001Vector?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.maswe_0001_vuln_title)) },
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
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                stringResource(id = R.string.maswe_0001_vuln_desc),
                style = MaterialTheme.typography.bodyMedium
            )

            // Context Info
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.maswe_context_info),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Text(stringResource(id = R.string.maswe_0001_vuln_vectors_title), fontWeight = FontWeight.Bold)

            Maswe0001Vector.entries.forEach { vector ->
                VectorButton(
                    title = stringResource(id = vector.titleVulnRes),
                    icon = vector.icon,
                    isActive = lastTriggeredVector == vector,
                    onClick = {
                        lastTriggeredVector = vector
                        lastResultPath = null
                        Maswe0001VulnerableLogic.executeVector(
                            vector = vector,
                            appData = appData,
                            context = context,
                            onResult = { pathOrTag -> lastResultPath = pathOrTag }
                        )
                    }
                )
            }

            AnimatedVisibility(
                visible = lastTriggeredVector != null,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                lastTriggeredVector?.let { vector ->
                    VulnResultCard(
                        vector = vector,
                        resultPath = lastResultPath
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun VectorButton(title: String, icon: ImageVector, isActive: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
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

@Composable
private fun VulnResultCard(
    vector: Maswe0001Vector,
    resultPath: String?
) {
    val adbCommand = remember(vector, resultPath) {
        buildAdbVerificationCommand(vector, resultPath)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Vector Triggered — Log Extracted",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.error.copy(alpha = 0.3f))

            if (resultPath != null) {
                Text(
                    text = if (vector == Maswe0001Vector.LOCAL_FILE) "📁 File Path:" else "📝 Logcat Tag:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onErrorContainer
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
                        color = MaterialTheme.colorScheme.error
                    )
                }
            } else {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Writing to logs/storage…",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.error.copy(alpha = 0.3f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Terminal,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onErrorContainer,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "ADB Verification:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onErrorContainer
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

private fun buildAdbVerificationCommand(vector: Maswe0001Vector, resultPath: String?): String {
    val pkg = "com.hasantuncay.mobsec"
    return when (vector) {
        Maswe0001Vector.SYSTEM_CONSOLE ->
            "adb logcat -d -s VULN_APP_TAG"
        Maswe0001Vector.NETWORK_INTERCEPTOR ->
            "adb logcat -d -s VULN_NETWORK"
        Maswe0001Vector.LOCAL_FILE ->
            "adb shell run-as $pkg cat files/app_debug.log"
        Maswe0001Vector.SDK_TELEMETRY ->
            "adb logcat -d -s VULN_SDK_SIMULATION"
        Maswe0001Vector.WEBVIEW_CONSOLE ->
            "adb logcat -d -s VULN_WEBVIEW"
    }
}
