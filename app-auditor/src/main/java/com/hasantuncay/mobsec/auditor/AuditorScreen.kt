package com.hasantuncay.mobsec.auditor

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hasantuncay.mobsec.auditor.contract.AuditorUiState
import com.hasantuncay.mobsec.auditor.domain.AuditSessionAggregator
import com.hasantuncay.mobsec.core.auditor.data.StorageAuditorTrees
import com.hasantuncay.mobsec.core.auditor.models.AuditVerdict
import com.hasantuncay.mobsec.core.auditor.models.AuditorNode
import com.hasantuncay.mobsec.core.auditor.models.Option
import com.hasantuncay.mobsec.core.auditor.models.QuestionNode
import com.hasantuncay.mobsec.core.auditor.models.ResultNode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuditorScreen(
    viewModel: AuditorViewModel = viewModel(),
    onNavigateBackToDashboard: (() -> Unit)? = null
) {
    var isDashboardMode by remember { mutableStateOf(false) }
    val uiState by viewModel.uiState.collectAsState()

    val handleBack = {
        if (!viewModel.popBackStack()) {
            if (onNavigateBackToDashboard != null) {
                onNavigateBackToDashboard()
            } else {
                isDashboardMode = true
            }
        }
    }

    // Sistem geri tuşu yönetimi (BackHandler)
    BackHandler(enabled = true) {
        handleBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (isDashboardMode) "MASVS Storage Auditor" else viewModel.getTitle(),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = handleBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Geri"
                        )
                    }
                },
                actions = {
                    if (!isDashboardMode) {
                        IconButton(onClick = { viewModel.restart() }) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Sıfırla"
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            if (isDashboardMode) {
                AuditorDashboard(
                    onSelectMaswe = { masweId ->
                        viewModel.loadTree(masweId)
                        isDashboardMode = false
                    }
                )
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // LCE-O State Machine Render Alanı
                    AnimatedContent(
                        targetState = uiState,
                        label = "Auditor LCE-O Animation",
                        transitionSpec = { fadeIn() togetherWith fadeOut() },
                        modifier = Modifier.fillMaxSize()
                    ) { state ->
                        when (state) {
                            is AuditorUiState.Loading -> {
                                LoadingContent()
                            }
                            is AuditorUiState.Question -> {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    AuditBreadcrumbBar(
                                        backStack = state.breadcrumbs,
                                        currentNodeId = viewModel.currentNodeId
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    QuestionContent(
                                        node = state.node,
                                        onOptionSelected = viewModel::selectOption
                                    )
                                }
                            }
                            is AuditorUiState.Result -> {
                                ResultContent(
                                    node = state.node,
                                    onRestart = viewModel::restart,
                                    onBackToMenu = {
                                        if (onNavigateBackToDashboard != null) {
                                            onNavigateBackToDashboard()
                                        } else {
                                            isDashboardMode = true
                                        }
                                    }
                                )
                            }
                            is AuditorUiState.Empty -> {
                                EmptyContent(
                                    onRetry = viewModel::restart,
                                    onBack = {
                                        if (onNavigateBackToDashboard != null) {
                                            onNavigateBackToDashboard()
                                        } else {
                                            isDashboardMode = true
                                        }
                                    }
                                )
                            }
                            is AuditorUiState.Error -> {
                                ErrorContent(
                                    message = state.message,
                                    canRetry = state.canRetry,
                                    onRetry = viewModel::restart,
                                    onBack = {
                                        if (onNavigateBackToDashboard != null) {
                                            onNavigateBackToDashboard()
                                        } else {
                                            isDashboardMode = true
                                        }
                                    }
                                )
                            }
                            is AuditorUiState.Offline -> {
                                OfflineContent(
                                    onDismiss = viewModel::restart
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Denetim ağacı yükleniyor...",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun EmptyContent(onRetry: () -> Unit, onBack: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.outline,
                    modifier = Modifier.size(56.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Ağaç Bulunamadı",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Bu kritere ait denetim ağacı boş veya henüz tanımlanmamış.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    OutlinedButton(onClick = onBack) {
                        Text("Geri Dön")
                    }
                    Button(onClick = onRetry) {
                        Text("Yeniden Dene")
                    }
                }
            }
        }
    }
}

@Composable
fun ErrorContent(
    message: String,
    canRetry: Boolean,
    onRetry: () -> Unit,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.4f)
            ),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.ErrorOutline,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(56.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Denetim Hatası",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.error
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    OutlinedButton(onClick = onBack) {
                        Text("Menüye Dön")
                    }
                    if (canRetry) {
                        Button(
                            onClick = onRetry,
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                        ) {
                            Text("Yeniden Başlat")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OfflineContent(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.WifiOff,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(56.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Çevrimdışı Mod",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ağ bağlantısı kesildi. Karar motoru yerel olarak çalışmaya devam etmektedir.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = onDismiss) {
                    Text("Devam Et")
                }
            }
        }
    }
}

@Composable
fun AuditBreadcrumbBar(backStack: List<String>, currentNodeId: String) {
    if (backStack.isEmpty()) return

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(backStack) { stepId ->
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
                border = null
            ) {
                Text(
                    text = stepId,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text("→", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.outline)
        }
        item {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Text(
                    text = currentNodeId,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

/**
 * MASVS-STORAGE Denetim Dashboard'u:
 * Kategori ilerleme yüzdesi ve AuditSessionAggregator üzerinden MASWE rozetlerini gösterir.
 */
@Composable
fun AuditorDashboard(onSelectMaswe: (String) -> Unit) {
    val progress = AuditSessionAggregator.getProgressPercentage()
    val recordedSessions = AuditSessionAggregator.getRecordedSessions()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "OWASP MASVS-STORAGE Denetim Ağaçları",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Mobil uygulamanızın depolama güvenliğini adım adım denetleyin.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // İlerleme ve Rozet Kartı (Violation 4)
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Kategori İlerlemesi",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "%$progress (${recordedSessions.size}/6)",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    LinearProgressIndicator(
                        progress = { progress / 100f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )

                    if (recordedSessions.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        val score = AuditSessionAggregator.calculateDeterministicScore(recordedSessions)
                        Text(
                            text = "Deterministik Güvenlik Skoru: $score/100",
                            style = MaterialTheme.typography.bodySmall,
                            color = if (score >= 80) Color(0xFF2E7D32) else Color(0xFFC62828),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        items(StorageAuditorTrees.allStorageTrees) { tree ->
            val session = AuditSessionAggregator.getSession(tree.id)

            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelectMaswe(tree.id) }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(
                                when (session?.verdict) {
                                    AuditVerdict.PASS -> Color(0xFF2E7D32).copy(alpha = 0.15f)
                                    AuditVerdict.FAIL -> Color(0xFFC62828).copy(alpha = 0.15f)
                                    AuditVerdict.WARNING -> Color(0xFFE65100).copy(alpha = 0.15f)
                                    AuditVerdict.INFO -> Color(0xFF0277BD).copy(alpha = 0.15f)
                                    null -> MaterialTheme.colorScheme.primaryContainer
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = when (session?.verdict) {
                                AuditVerdict.PASS -> Icons.Default.CheckCircle
                                AuditVerdict.FAIL -> Icons.Default.Warning
                                AuditVerdict.WARNING -> Icons.Default.Warning
                                AuditVerdict.INFO -> Icons.Default.Info
                                null -> Icons.Default.Security
                            },
                            contentDescription = null,
                            tint = when (session?.verdict) {
                                AuditVerdict.PASS -> Color(0xFF2E7D32)
                                AuditVerdict.FAIL -> Color(0xFFC62828)
                                AuditVerdict.WARNING -> Color(0xFFE65100)
                                AuditVerdict.INFO -> Color(0xFF0277BD)
                                null -> MaterialTheme.colorScheme.onPrimaryContainer
                            }
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = tree.id.uppercase(),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )

                            // Rozet (AuditSessionAggregator üzerinden)
                            if (session != null) {
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = when (session.verdict) {
                                        AuditVerdict.PASS -> Color(0xFF2E7D32)
                                        AuditVerdict.FAIL -> Color(0xFFC62828)
                                        AuditVerdict.WARNING -> Color(0xFFE65100)
                                        AuditVerdict.INFO -> Color(0xFF0277BD)
                                    }
                                ) {
                                    Text(
                                        text = session.verdict.name,
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }

                        Text(
                            text = tree.title,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun QuestionContent(node: QuestionNode, onOptionSelected: (Option) -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = node.text,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 28.dp)
            )

            node.options.forEach { option ->
                Button(
                    onClick = { onOptionSelected(option) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = option.text,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ResultContent(
    node: ResultNode,
    onRestart: () -> Unit,
    onBackToMenu: () -> Unit
) {
    val status = node.status.lowercase()
    val isSuccess = status == "pass"
    val isWarning = status == "warning"
    val isInfo = status == "info"

    val (icon, color, title, desc) = when {
        isSuccess -> Quadruple(
            Icons.Filled.CheckCircle,
            Color(0xFF2E7D32),
            "GÜVENLİ (PASS)",
            "Tebrikler! Uygulama bu MASVS güvenlik kriterine tam uyum sağlamaktadır."
        )
        isWarning -> Quadruple(
            Icons.Filled.Info,
            Color(0xFFE65100),
            "UYARI (WARNING)",
            "L1 güvenlik seviyesi karşılanıyor ancak L2 donanım güvencesi (StrongBox / TEE) eksik."
        )
        isInfo -> Quadruple(
            Icons.Filled.Info,
            Color(0xFF0277BD),
            "BİLGİ (INFO)",
            "Bu kriter uygulamanızın mimari bağlamına göre incelenmelidir."
        )
        else -> Quadruple(
            Icons.Filled.Warning,
            Color(0xFFC62828),
            "ZAFİYET TESPİT EDİLDİ (FAIL)",
            "Kritik güvenlik eksikliği saptandı! Lütfen ilgili MASWE standardına uygun şekilde zafiyeti kapatın."
        )
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.08f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,
                modifier = Modifier
                    .size(72.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = color
            )

            Text(
                text = desc,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 20.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = onRestart,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Tekrar Denetle")
                }
                Button(
                    onClick = onBackToMenu,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Menüye Dön")
                }
            }
        }
    }
}

private data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
