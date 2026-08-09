package com.hasantuncay.mobsec.attacker.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

// ═════════════════════════════════════════════════════════════════════════════
// DATA MODELS
// ═════════════════════════════════════════════════════════════════════════════
data class AttackerExploit(
    val id: String,
    val title: String,
    val description: String,
    val cwe: String,
    val status: String,
    val isActive: Boolean = true,
    val onActivate: (() -> Unit)? = null
)

data class AttackerCategory(
    val title: String,
    val icon: ImageVector,
    val exploits: List<AttackerExploit>
)

// ═════════════════════════════════════════════════════════════════════════════
// MAIN SCREEN
// ═════════════════════════════════════════════════════════════════════════════
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onOpenExploitReceiver: () -> Unit,
    onOpenPathTraversalExploit: () -> Unit,
    onOpenLogcatExploit: () -> Unit
) {
    // 1. DYNAMIC DATA STRUCTURE (Groups exploits by MASVS Category)
    val categories = listOf(
        AttackerCategory(
            title = stringResource(id = R.string.cat_masvs_storage),
            icon = Icons.Default.DataArray,
            exploits = listOf(
                AttackerExploit(
                    id = stringResource(id = R.string.format_maswe0005_id, stringResource(id = R.string.exploit_id_sys_logs)),
                    title = stringResource(id = R.string.exploit_title_logcat),
                    description = stringResource(id = R.string.exploit_desc_logcat),
                    cwe = stringResource(id = R.string.exploit_cwe_logcat),
                    status = stringResource(id = R.string.exploit_status_logcat),
                    onActivate = onOpenLogcatExploit
                ),
                AttackerExploit(
                    id = stringResource(id = R.string.format_maswe0002_id, stringResource(id = R.string.exploit_id_v4)),
                    title = stringResource(id = R.string.exploit_title_v4),
                    description = stringResource(id = R.string.exploit_desc_v4),
                    cwe = stringResource(id = R.string.exploit_cwe_v4),
                    status = stringResource(id = R.string.exploit_status_v4),
                    onActivate = onOpenExploitReceiver
                ),
                AttackerExploit(
                    id = stringResource(id = R.string.format_maswe0002_id, stringResource(id = R.string.exploit_id_v8)),
                    title = stringResource(id = R.string.exploit_title_v8),
                    description = stringResource(id = R.string.exploit_desc_v8),
                    cwe = stringResource(id = R.string.exploit_cwe_v8),
                    status = stringResource(id = R.string.exploit_status_v8),
                    onActivate = onOpenPathTraversalExploit
                )
            )
        ),
        AttackerCategory(
            title = stringResource(id = R.string.cat_masvs_network),
            icon = Icons.Default.PublicOff,
            exploits = listOf(
                AttackerExploit(
                    id = stringResource(id = R.string.format_maswe0003_id, stringResource(id = R.string.exploit_id_vx)),
                    title = stringResource(id = R.string.exploit_title_vx),
                    description = stringResource(id = R.string.exploit_desc_vx),
                    cwe = stringResource(id = R.string.exploit_cwe_vx),
                    status = stringResource(id = R.string.label_coming_soon),
                    isActive = false
                )
            )
        ),
        AttackerCategory(
            title = stringResource(id = R.string.cat_masvs_crypto),
            icon = Icons.Default.Lock,
            exploits = emptyList()
        ),
        AttackerCategory(
            title = stringResource(id = R.string.cat_masvs_auth),
            icon = Icons.Default.Security,
            exploits = emptyList()
        ),
        AttackerCategory(
            title = stringResource(id = R.string.cat_masvs_platform),
            icon = Icons.Default.Android,
            exploits = emptyList()
        )
    )

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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A00)),
                    modifier = Modifier
                        .fillMaxWidth()
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
            }

            item {
                SectionHeader(title = stringResource(id = R.string.section_active_exploits), icon = Icons.Default.BugReport)
            }

            // DYNAMIC LIST RENDER
            items(categories) { category ->
                AttackerCategoryAccordion(category = category)
            }

            item {
                SectionHeader(title = stringResource(id = R.string.section_target_information), icon = Icons.Default.Info)
                TargetInfoCard()
            }
        }
    }
}

// ═════════════════════════════════════════════════════════════════════════════
// UI COMPONENTS
// ═════════════════════════════════════════════════════════════════════════════
@Composable
fun AttackerCategoryAccordion(category: AttackerCategory) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF121212)),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFF222222))
    ) {
        Column {
            // HEADER (Clickable to Expand/Collapse)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(category.icon, contentDescription = null, tint = AttackerRed, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = category.title,
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = AttackerTextDim
                )
            }

            // EXPLOIT LIST
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF0A0A0A))
                        .padding(bottom = 12.dp)
                ) {
                    if (category.exploits.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.label_coming_soon),
                            color = AttackerTextDim.copy(alpha = 0.5f),
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                        )
                    } else {
                        category.exploits.forEachIndexed { index, exploit ->
                            if (exploit.isActive) {
                                ExploitCard(exploit = exploit, modifier = Modifier.padding(top = 12.dp))
                            } else {
                                PlaceholderExploitCard(exploit = exploit, modifier = Modifier.padding(top = 12.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ExploitCard(exploit: AttackerExploit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        colors = CardDefaults.cardColors(containerColor = AttackerCard),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, AttackerRed.copy(alpha = 0.2f))
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Bolt, contentDescription = null, tint = AttackerRed)
                    Text(text = exploit.id, color = AttackerRed, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
                }
                Box(
                    modifier = Modifier
                        .background(Color(0xFF002200), RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(text = stringResource(id = R.string.label_active), color = AttackerGreen, fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                }
            }

            Text(text = exploit.title, color = Color.White, fontWeight = FontWeight.Medium, fontSize = 15.sp)
            Text(text = exploit.description, color = AttackerTextDim, fontSize = 12.sp, lineHeight = 18.sp)

            Text(text = "CWE: ${exploit.cwe}", color = AttackerYellow, fontSize = 11.sp, fontFamily = FontFamily.Monospace)

            Divider(color = Color.White.copy(alpha = 0.1f))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "▸ ${exploit.status}", color = AttackerGreen, fontFamily = FontFamily.Monospace, fontSize = 11.sp)
                Button(
                    onClick = { exploit.onActivate?.invoke() },
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
fun PlaceholderExploitCard(exploit: AttackerExploit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF111111)),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFF222222))
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(text = exploit.id, color = AttackerTextDim, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 11.sp)
                Box(
                    modifier = Modifier
                        .border(1.dp, AttackerTextDim.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(text = stringResource(id = R.string.label_coming_soon), color = AttackerTextDim, fontSize = 9.sp, fontFamily = FontFamily.Monospace)
                }
            }
            Text(text = exploit.title, color = AttackerTextDim, fontWeight = FontWeight.Medium, fontSize = 13.sp)
            Text(text = exploit.description, color = AttackerTextDim.copy(alpha = 0.5f), fontSize = 11.sp)
        }
    }
}

@Composable
fun SectionHeader(title: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(icon, contentDescription = null, tint = AttackerRed, modifier = Modifier.size(20.dp))
        Text(text = title, color = AttackerRed, fontWeight = FontWeight.Bold, fontSize = 13.sp)
        Divider(color = AttackerRed.copy(alpha = 0.3f), modifier = Modifier.weight(1f))
    }
}

@Composable
fun TargetInfoCard() {
    val targetPkg = stringResource(id = R.string.target_val_package)
    Card(
        modifier = Modifier.fillMaxWidth(),
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
