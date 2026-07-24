package com.hasantuncay.mobsec.storage.maswe0002

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.Maswe0002Vector
import com.hasantuncay.mobsec.common.models.data.LocalMasterclassViewModel
import com.hasantuncay.mobsec.common.ui.components.GdprPiiCard
import com.hasantuncay.mobsec.common.ui.components.PciDssCard
import com.hasantuncay.mobsec.common.ui.components.SessionDataCard
import kotlinx.coroutines.launch

/**
 * Screen for MASWE-0002: Insecure Storage — Vulnerable implementation.
 *
 * Displays the sensitive data context and provides buttons to trigger each
 * of the five insecure storage vectors. After each trigger, the resulting
 * file path or content URI is displayed on screen alongside an ADB verification
 * command, so the user can immediately confirm the plaintext exposure.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0002VulnerableScreen(onBack: () -> Unit) {
    val viewModel = LocalMasterclassViewModel.current
    val appData by viewModel.masterclassData.collectAsState()
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    // Track last triggered path/URI for each vector
    var lastResultPath by remember { mutableStateOf<String?>(null) }
    var lastTriggeredVector by remember { mutableStateOf<Maswe0002Vector?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.maswe_0002_vuln_title)) },
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
            // Description
            Text(
                text = stringResource(id = R.string.maswe_0002_vuln_desc),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
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

            HorizontalDivider()
            Text(
                text = stringResource(id = R.string.maswe_0002_vuln_vectors_title),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall
            )

            // Vector trigger buttons
            Maswe0002Vector.entries.forEach { vector ->
                Maswe0002VectorButton(
                    title = stringResource(id = vector.titleVulnRes),
                    icon = vector.icon,
                    isActive = lastTriggeredVector == vector,
                    onClick = {
                        lastTriggeredVector = vector
                        lastResultPath = null // reset while loading
                        coroutineScope.launch {
                            Maswe0002VulnerableLogic.executeVector(
                                vector = vector,
                                appData = appData,
                                context = context,
                                onResult = { path -> lastResultPath = path }
                            )
                        }
                    }
                )
            }

            // Result panel — shows after vector is triggered
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

// ──────────────────────────────────────────────────────────────────────────
// UI Components
// ──────────────────────────────────────────────────────────────────────────

@Composable
private fun Maswe0002VectorButton(
    title: String,
    icon: ImageVector,
    isActive: Boolean,
    onClick: () -> Unit
) {
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

/**
 * Result card shown after a vector is triggered.
 * Displays the file/URI path and a ready-to-use ADB verification command.
 */
@Composable
private fun VulnResultCard(
    vector: Maswe0002Vector,
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
            // Header
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.maswe_0002_ui_vector_triggered),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.error.copy(alpha = 0.3f))

            // Written path / URI
            if (resultPath != null) {
                Text(
                    text = stringResource(id = R.string.maswe_0002_ui_location_label),
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
                // Loading state (async operations like DataStore/Room)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.maswe_0002_ui_writing_storage),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }

            // ADB verification command
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
                    text = stringResource(id = R.string.maswe_0002_ui_adb_verification),
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

/**
 * Builds a context-specific ADB shell command for verifying the plaintext exposure
 * of each vector. This makes the vulnerability immediately actionable for the learner.
 */
private fun buildAdbVerificationCommand(vector: Maswe0002Vector, resultPath: String?): String {
    val pkg = "com.hasantuncay.mobsec"
    return when (vector) {
        Maswe0002Vector.SHARED_PREFS_PLAINTEXT ->
            "adb shell run-as $pkg \\\n  cat shared_prefs/maswe0002_session.xml"

        Maswe0002Vector.DATASTORE_UNENCRYPTED ->
            "# Option A — strings extraction:\n" +
            "adb shell run-as $pkg \\\n  cat files/datastore/maswe0002_store.preferences_pb | strings\n\n" +
            "# Option B — raw hex dump:\n" +
            "adb shell run-as $pkg \\\n  hexdump -C files/datastore/maswe0002_store.preferences_pb"

        Maswe0002Vector.SQLITE_PLAINTEXT ->
            "# Main database:\n" +
            "adb shell run-as $pkg sqlite3 \\\n  databases/maswe0002_vuln.db \\\n  \"SELECT * FROM sensitive_records;\"\n\n" +
            "# WAL journal (also contains plaintext):\n" +
            "adb shell run-as $pkg \\\n  strings databases/maswe0002_vuln.db-wal"

        Maswe0002Vector.FILE_PROVIDER_ROOT_PATH ->
            "# The content:// URI above would let an attacker app call:\n" +
            "# contentResolver.openInputStream(Uri.parse(\"$resultPath\"))\n\n" +
            "# ADB content read (simulates attacker app):\n" +
            if (resultPath != null)
                "adb shell content read \\\n  --uri \"$resultPath\""
            else
                "adb logcat -s VULN_0002_FILEPROVIDER"

        Maswe0002Vector.EXTERNAL_STORAGE ->
            "# No root needed — readable via ADB/MTP on all API levels:\n" +
            "adb shell cat \\\n  /sdcard/Android/data/$pkg/files/maswe0002_external_leak.json\n\n" +
            "# API < 29 — any app with READ_EXTERNAL_STORAGE can call:\n" +
            "# File(\"/sdcard/Android/data/$pkg/files/maswe0002_external_leak.json\").readText()"

        Maswe0002Vector.WEBVIEW_DOM_STORAGE ->
            "# DOM Storage is written to LevelDB inside app_webview:\n" +
            "adb shell run-as $pkg \\\n  cat \"app_webview/Default/Local Storage/leveldb/LOG\"\n\n" +
            "# Requires root to dump full LevelDB contents, or ADB backup."

        Maswe0002Vector.CACHE_DIRECTORY ->
            "# Check cacheDir for lingering sensitive PDF files:\n" +
            if (resultPath != null)
                "adb shell run-as $pkg \\\n  cat \"${resultPath.substringAfter(pkg + "/")}\""
            else
                "adb shell run-as $pkg ls -la cache/"
    }
}
