package com.hasantuncay.mobsec.secure.storage.maswe0001

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.Maswe0001Vector
import com.hasantuncay.mobsec.common.models.data.LocalMasterclassViewModel
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
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.Shield


import com.hasantuncay.mobsec.common.ui.components.AnalyticsLogCard
import com.hasantuncay.mobsec.common.ui.components.GdprPiiCard
import com.hasantuncay.mobsec.common.ui.components.PciDssCard
import com.hasantuncay.mobsec.common.ui.components.SessionDataCard
import com.hasantuncay.mobsec.common.ui.components.UserDataCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0001LogSecureScreen(onBack: () -> Unit) {
    val viewModel = LocalMasterclassViewModel.current
    val appData by viewModel.masterclassData.collectAsState()
    
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    var lastResultPath by remember { mutableStateOf<String?>(null) }
    var lastTriggeredVector by remember { mutableStateOf<Maswe0001Vector?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.maswe_0001_secure_title)) },
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
                stringResource(id = R.string.maswe_0001_secure_desc),
                style = MaterialTheme.typography.bodyMedium
            )

            // Modular Data Displays for Context
            UserDataCard(data = appData.userContext)
            GdprPiiCard(data = appData.gdprPii)
            PciDssCard(data = appData.pciDss)
            SessionDataCard(data = appData.networkSession)
            AnalyticsLogCard(data = appData.analyticsLogs)

            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider()
            Text(stringResource(id = R.string.maswe_0001_secure_vectors_title), fontWeight = FontWeight.Bold)

            Maswe0001Vector.entries.forEach { vector ->
                VectorButton(
                    title = stringResource(id = vector.titleSecureRes),
                    icon = vector.icon,
                    isActive = lastTriggeredVector == vector,
                    onClick = {
                        lastTriggeredVector = vector
                        lastResultPath = null
                        Maswe0001SecureLogic.executeVector(
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
                    SecureResultCard(
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
                MaterialTheme.colorScheme.primary
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
                imageVector = if (isActive) Icons.Default.Shield else icon, 
                contentDescription = null, 
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
private fun SecureResultCard(
    vector: Maswe0001Vector,
    resultPath: String?
) {
    val adbCommand = remember(vector, resultPath) {
        buildAdbVerificationCommand(vector, resultPath)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Shield,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Defense Activated",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))

            if (resultPath != null) {
                Text(
                    text = if (vector == Maswe0001Vector.LOCAL_FILE) "📁 Safe File Path:" else "📝 Secure Tag:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
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
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            } else {
                Text(
                    text = "Executing secure logic…",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Terminal,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "ADB Verification (No Leak):",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
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
            "adb logcat -d -s SECURE_APP_TAG"
        Maswe0001Vector.NETWORK_INTERCEPTOR ->
            "adb logcat -d -s SECURE_NETWORK"
        Maswe0001Vector.LOCAL_FILE ->
            "adb shell run-as $pkg cat files/diagnostics_secure.json\n# Will be fully encrypted (Jetpack Security)"
        Maswe0001Vector.SDK_TELEMETRY ->
            "adb logcat -d -s SECURE_SDK_SIMULATION\n# PII should be masked/hashed"
        Maswe0001Vector.WEBVIEW_CONSOLE ->
            "adb logcat -d -s SECURE_WEBVIEW\n# Cookies filtered out"
    }
}
