package com.hasantuncay.mobsec.attacker.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasantuncay.mobsec.attacker.R
import com.hasantuncay.mobsec.attacker.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(onOpenExploitReceiver: () -> Unit, onOpenLogcatExploit: () -> Unit) {
    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = AttackerBackground,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0D0D0D)),
                title = {
                    Column {
                        Text(
                            text = stringResource(id = R.string.attacker_main_title_header),
                            fontWeight = FontWeight.Bold,
                            color = AttackerRed,
                            fontSize = 18.sp
                        )
                        Text(
                            text = stringResource(id = R.string.attacker_main_subtitle_header),
                            color = AttackerTextDim,
                            fontSize = 11.sp
                        )
                    }
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Security,
                        contentDescription = null,
                        tint = AttackerRed,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A00)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .border(1.dp, AttackerYellow.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(Icons.Default.Warning, contentDescription = null, tint = AttackerYellow)
                    Text(
                        text = stringResource(id = R.string.attacker_warning_desc),
                        color = AttackerYellow,
                        fontSize = 12.sp,
                        lineHeight = 18.sp
                    )
                }
            }

            // Active Exploits Section
            SectionHeader(title = stringResource(id = R.string.section_active_exploits), icon = Icons.Default.BugReport)

            ExploitCard(
                exploitId = stringResource(id = R.string.exploit_maswe0002_id),
                title = stringResource(id = R.string.exploit_maswe0002_title),
                description = stringResource(id = R.string.exploit_maswe0002_desc),
                cwe = stringResource(id = R.string.exploit_maswe0002_cwe),
                status = stringResource(id = R.string.exploit_maswe0002_status),
                onActivate = onOpenExploitReceiver
            )

            ExploitCard(
                exploitId = "MASWE-0001",
                title = "Logcat Snooping",
                description = "Attempts to read system logs using the READ_LOGS permission. Can intercept sensitive data logged by app-vulnerable if granted via ADB.",
                cwe = "CWE-532, CWE-538",
                status = "ACTIVE — System Access Required",
                onActivate = onOpenLogcatExploit
            )

            // Future Exploits (placeholder)
            SectionHeader(title = stringResource(id = R.string.section_future_exploits), icon = Icons.Default.Lock)

            PlaceholderExploitCard(
                exploitId = stringResource(id = R.string.exploit_maswe0064_id),
                title = stringResource(id = R.string.exploit_maswe0064_title),
                description = stringResource(id = R.string.exploit_maswe0064_desc)
            )
            PlaceholderExploitCard(
                exploitId = stringResource(id = R.string.exploit_maswe0003_id),
                title = stringResource(id = R.string.exploit_maswe0003_title),
                description = stringResource(id = R.string.exploit_maswe0003_desc)
            )

            // Target Info
            SectionHeader(title = stringResource(id = R.string.section_target_information), icon = Icons.Default.Info)
            TargetInfoCard()

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun SectionHeader(title: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(icon, contentDescription = null, tint = AttackerRed, modifier = Modifier.size(20.dp))
        Text(text = title, color = AttackerRed, fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Divider(color = AttackerRed.copy(alpha = 0.3f), modifier = Modifier.weight(1f))
    }
}

@Composable
fun ExploitCard(
    exploitId: String,
    title: String,
    description: String,
    cwe: String,
    status: String,
    onActivate: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = AttackerCard),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Bolt, contentDescription = null, tint = AttackerRed)
                    Text(text = exploitId, color = AttackerRed, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
                }
                Box(
                    modifier = Modifier
                        .background(Color(0xFF002200), RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(text = stringResource(id = R.string.label_active), color = AttackerGreen, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                }
            }

            Text(text = title, color = Color.White, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Text(text = description, color = AttackerTextDim, fontSize = 12.sp, lineHeight = 18.sp)

            Text(text = "CWE: $cwe", color = AttackerYellow, fontSize = 11.sp, fontFamily = FontFamily.Monospace)

            Divider(color = Color.White.copy(alpha = 0.1f))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "▸ $status", color = AttackerGreen, fontFamily = FontFamily.Monospace, fontSize = 11.sp)
                Button(
                    onClick = onActivate,
                    colors = ButtonDefaults.buttonColors(containerColor = AttackerRed),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = stringResource(id = R.string.btn_exploit), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun PlaceholderExploitCard(exploitId: String, title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF111111)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = exploitId, color = AttackerTextDim, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 11.sp)
                Box(
                    modifier = Modifier
                        .border(1.dp, AttackerTextDim.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(text = stringResource(id = R.string.label_coming_soon), color = AttackerTextDim, fontSize = 9.sp, fontFamily = FontFamily.Monospace)
                }
            }
            Text(text = title, color = AttackerTextDim, fontWeight = FontWeight.Medium, fontSize = 13.sp)
            Text(text = description, color = AttackerTextDim.copy(alpha = 0.5f), fontSize = 11.sp)
        }
    }
}

@Composable
fun TargetInfoCard() {
    val targetPkg = stringResource(id = R.string.target_val_package)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFF333333))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TargetInfoRow(stringResource(id = R.string.target_info_package), targetPkg)
            TargetInfoRow(stringResource(id = R.string.target_info_authority), "$targetPkg.fileprovider")
            TargetInfoRow(stringResource(id = R.string.target_info_file), stringResource(id = R.string.target_val_file))
            TargetInfoRow(stringResource(id = R.string.target_info_method), stringResource(id = R.string.target_val_method))
            TargetInfoRow(stringResource(id = R.string.target_info_root), stringResource(id = R.string.target_val_root))
            TargetInfoRow(stringResource(id = R.string.target_info_api), stringResource(id = R.string.target_val_api))
        }
    }
}

@Composable
fun TargetInfoRow(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = "$label: ", color = AttackerTextDim, fontSize = 11.sp, modifier = Modifier.weight(0.4f))
        Text(text = value, color = Color.White, fontSize = 11.sp, modifier = Modifier.weight(0.6f), fontFamily = FontFamily.Monospace)
    }
}
