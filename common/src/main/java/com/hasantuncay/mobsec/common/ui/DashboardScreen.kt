package com.hasantuncay.mobsec.common.ui

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.DataArray
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.CloudSync
import androidx.compose.material.icons.filled.FolderShared
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.navigation.Maswe0001LogRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0002SharedPrefsRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0003BackupRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0004BackupExcludedRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0006PrivateStorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0007SharedStorageRoute

data class MasweItem(
    @StringRes val idRes: Int,
    @StringRes val titleRes: Int,
    val route: Any?,
    val icon: ImageVector = Icons.Default.BugReport
)

enum class MasvsCategory(
    @StringRes val titleRes: Int,
    val items: List<MasweItem>
) {
    STORAGE(
        titleRes = R.string.masvs_storage,
        items = listOf(
            MasweItem(
                idRes = R.string.maswe_0001_id,
                titleRes = R.string.maswe_0001_title,
                route = Maswe0001LogRoute,
                icon = Icons.Default.DataArray
            ),
            MasweItem(
                idRes = R.string.maswe_0002_id,
                titleRes = R.string.maswe_0002_title,
                route = Maswe0002SharedPrefsRoute,
                icon = Icons.Default.NoEncryption
            ),
            MasweItem(
                idRes = R.string.maswe_0003_id,
                titleRes = R.string.maswe_0003_title,
                route = Maswe0003BackupRoute,
                icon = Icons.Default.CloudSync
            ),
            MasweItem(
                idRes = R.string.maswe_0004_id,
                titleRes = R.string.maswe_0004_title,
                route = Maswe0004BackupExcludedRoute,
                icon = Icons.Default.CloudOff
            ),
            MasweItem(
                idRes = R.string.maswe_0006_id,
                titleRes = R.string.maswe_0006_title,
                route = Maswe0006PrivateStorageRoute,
                icon = Icons.Default.FolderSpecial
            ),
            MasweItem(
                idRes = R.string.maswe_0007_id,
                titleRes = R.string.maswe_0007_title,
                route = Maswe0007SharedStorageRoute,
                icon = Icons.Default.FolderShared
            )
        )
    ),
    CRYPTO(titleRes = R.string.masvs_crypto, items = emptyList()),
    NETWORK(titleRes = R.string.masvs_network, items = emptyList()),
    AUTH(titleRes = R.string.masvs_auth, items = emptyList()),
    PLATFORM(titleRes = R.string.masvs_platform, items = emptyList()),
    CODE(titleRes = R.string.masvs_code, items = emptyList()),
    RESILIENCE(titleRes = R.string.masvs_resilience, items = emptyList()),
    PRIVACY(titleRes = R.string.masvs_privacy, items = emptyList())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(title: String, onNavigate: (Any) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(MasvsCategory.values()) { category ->
                MasvsCategoryAccordion(category, onNavigate)
            }
        }
    }
}

@Composable
fun MasvsCategoryAccordion(category: MasvsCategory, onNavigate: (Any) -> Unit) {
    var expanded by remember { mutableStateOf(category.items.isNotEmpty()) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            // Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
                    .clickable { expanded = !expanded }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = category.titleRes),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = if (expanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

            // Items List
            AnimatedVisibility(visible = expanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    category.items.forEachIndexed { index, item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(enabled = item.route != null) {
                                    item.route?.let { onNavigate(it) }
                                }
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                tint = if (item.route != null) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = stringResource(id = item.idRes),
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = stringResource(id = item.titleRes),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        if (index < category.items.lastIndex) {
                            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        }
                    }
                    if (category.items.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.dashboard_coming_soon),
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
