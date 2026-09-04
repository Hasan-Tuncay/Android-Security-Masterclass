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
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.DataArray
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.CloudSync
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.FolderShared
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.LinkOff
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Javascript
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.VpnKey
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Screenshot
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.AutoMode
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material.icons.filled.VpnKey
import androidx.compose.material.icons.filled.DeviceUnknown
import androidx.compose.material.icons.filled.SystemUpdate
import androidx.compose.material.icons.filled.SystemUpdateAlt
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.NoEncryption
import androidx.compose.material.icons.filled.Api
import androidx.compose.material.icons.filled.SettingsEthernet
import androidx.compose.material.icons.filled.Dns
import androidx.compose.material.icons.filled.AutoDelete
import androidx.compose.material.icons.filled.PersonOff
import androidx.compose.material.icons.filled.BuildCircle
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.automirrored.filled.Rule
import androidx.compose.material.icons.filled.DataArray
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.LaptopWindows
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.SettingsCell
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.MobileOff
import androidx.compose.material.icons.filled.UpdateDisabled
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.PestControl
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.SettingsBackupRestore
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.CodeOff
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.TextFormat
import androidx.compose.material.icons.filled.Subtitles
import androidx.compose.material.icons.filled.DoorBack
import androidx.compose.material.icons.filled.AvTimer
import androidx.compose.material.icons.filled.AutoFixOff
import androidx.compose.material.icons.automirrored.filled.FactCheck
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.DataUsage
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.navigation.Maswe0005LogRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0001StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0002StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0003StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0004StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0006StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0007CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0008CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0009CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0010CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0011CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0012CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0013CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0014CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0015CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0016CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0017CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0018AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0019AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0020AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0021AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0022AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0023AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0024AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0025AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0026NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0027NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0028NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0029PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0030PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0031PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0032PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0033PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0034PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0035PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0036PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0037PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0038PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0039PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0040PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0041CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0042CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0043CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0044CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0045CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0046CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0047CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0048CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0049CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0050CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0051ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0052ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0053ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0054ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0055ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0056ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0057ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0058ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0059ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0060ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0061ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0062ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0063ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0064ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0065ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0066PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0067PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0068PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0069PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0070PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0071PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0072PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0073PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0074PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0075PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0076PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0077PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0078PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.DataVaultRoute
import com.hasantuncay.mobsec.common.models.DashboardRegistry
import com.hasantuncay.mobsec.common.models.MasvsCategoryData
import com.hasantuncay.mobsec.common.models.MasweItemData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    title: String, 
    onNavigate: (Any) -> Unit,
    onOpenDocumentation: (String) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { onNavigate(DataVaultRoute) },
                icon = { Icon(Icons.Default.Lock, contentDescription = stringResource(id = R.string.dashboard_data_vault_content_desc)) },
                text = { Text(stringResource(id = R.string.dashboard_data_vault_btn)) },
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary
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
            items(DashboardRegistry.categories) { category ->
                MasvsCategoryAccordion(category, onNavigate, onOpenDocumentation)
            }
        }
    }
}

@Composable
fun MasvsCategoryAccordion(
    category: MasvsCategoryData, 
    onNavigate: (Any) -> Unit,
    onOpenDocumentation: (String) -> Unit = {}
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    var expanded by remember { mutableStateOf(false) }

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
                    contentDescription = if (expanded) stringResource(R.string.action_collapse) else stringResource(R.string.action_expand),
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
                                .clickable {
                                    if (item.route != null) {
                                        onNavigate(item.route)
                                    } else {
                                        android.widget.Toast.makeText(context, context.getString(R.string.msg_coming_soon), android.widget.Toast.LENGTH_SHORT).show()
                                    }
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
                                    text = item.meta.masweId,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = stringResource(id = item.meta.titleRes),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            // DOCS Button for Documentation
                            if (item.meta.masweId.isNotEmpty()) {
                                val masweIdStr = item.meta.masweId
                                OutlinedButton(
                                    onClick = { onOpenDocumentation(masweIdStr) },
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                                    modifier = Modifier.height(32.dp)
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.btn_docs),
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
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
