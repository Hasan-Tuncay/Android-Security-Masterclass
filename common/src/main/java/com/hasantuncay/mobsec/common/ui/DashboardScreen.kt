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
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Message
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
import androidx.compose.material.icons.filled.LibraryBooks
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
import androidx.compose.material.icons.filled.Rule
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
import androidx.compose.material.icons.filled.FactCheck
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
                route = Maswe0001StorageRoute,
                icon = Icons.Default.NoEncryption
            ),
            MasweItem(
                idRes = R.string.maswe_0002_id,
                titleRes = R.string.maswe_0002_title,
                route = Maswe0002StorageRoute,
                icon = Icons.Default.FolderShared
            ),
            MasweItem(
                idRes = R.string.maswe_0003_id,
                titleRes = R.string.maswe_0003_title,
                route = Maswe0003StorageRoute,
                icon = Icons.Default.CloudSync
            ),
            MasweItem(
                idRes = R.string.maswe_0004_id,
                titleRes = R.string.maswe_0004_title,
                route = Maswe0004StorageRoute,
                icon = Icons.Default.CloudOff
            ),
            MasweItem(
                idRes = R.string.maswe_0005_id,
                titleRes = R.string.maswe_0005_title,
                route = Maswe0005LogRoute,
                icon = Icons.Default.DataArray
            ),
            MasweItem(
                idRes = R.string.maswe_0006_id,
                titleRes = R.string.maswe_0006_title,
                route = Maswe0006StorageRoute,
                icon = Icons.Default.FolderSpecial
            )
        )
    ),
    CRYPTO(
        titleRes = R.string.masvs_crypto,
        items = listOf(
            MasweItem(idRes = R.string.maswe_0007_id, titleRes = R.string.maswe_0007_title, route = Maswe0007CryptoRoute, icon = Icons.Default.NoEncryption),
            MasweItem(idRes = R.string.maswe_0008_id, titleRes = R.string.maswe_0008_title, route = Maswe0008CryptoRoute, icon = Icons.Default.DataArray),
            MasweItem(idRes = R.string.maswe_0009_id, titleRes = R.string.maswe_0009_title, route = Maswe0009CryptoRoute, icon = Icons.Default.DataObject),
            MasweItem(idRes = R.string.maswe_0010_id, titleRes = R.string.maswe_0010_title, route = Maswe0010CryptoRoute, icon = Icons.Default.Build),
            MasweItem(idRes = R.string.maswe_0011_id, titleRes = R.string.maswe_0011_title, route = Maswe0011CryptoRoute, icon = Icons.Default.BugReport),
            MasweItem(idRes = R.string.maswe_0012_id, titleRes = R.string.maswe_0012_title, route = Maswe0012CryptoRoute, icon = Icons.Default.FolderSpecial),
            MasweItem(idRes = R.string.maswe_0013_id, titleRes = R.string.maswe_0013_title, route = Maswe0013CryptoRoute, icon = Icons.Default.CloudOff),
            MasweItem(idRes = R.string.maswe_0014_id, titleRes = R.string.maswe_0014_title, route = Maswe0014CryptoRoute, icon = Icons.Default.FolderShared),
            MasweItem(idRes = R.string.maswe_0015_id, titleRes = R.string.maswe_0015_title, route = Maswe0015CryptoRoute, icon = Icons.Default.CloudSync),
            MasweItem(idRes = R.string.maswe_0016_id, titleRes = R.string.maswe_0016_title, route = Maswe0016CryptoRoute, icon = Icons.Default.Lock),
            MasweItem(idRes = R.string.maswe_0017_id, titleRes = R.string.maswe_0017_title, route = Maswe0017CryptoRoute, icon = Icons.Default.NoEncryption)
        )
    ),
    NETWORK(
        titleRes = R.string.masvs_network,
        items = listOf(
            MasweItem(idRes = R.string.maswe_0026_id, titleRes = R.string.maswe_0026_title, route = Maswe0026NetworkRoute, icon = Icons.Default.NoEncryption),
            MasweItem(idRes = R.string.maswe_0027_id, titleRes = R.string.maswe_0027_title, route = Maswe0027NetworkRoute, icon = Icons.Default.Block),
            MasweItem(idRes = R.string.maswe_0028_id, titleRes = R.string.maswe_0028_title, route = Maswe0028NetworkRoute, icon = Icons.Default.BugReport)
        )
    ),
    AUTH(
        titleRes = R.string.masvs_auth,
        items = listOf(
            MasweItem(idRes = R.string.maswe_0018_id, titleRes = R.string.maswe_0018_title, route = Maswe0018AuthRoute, icon = Icons.Default.Security),
            MasweItem(idRes = R.string.maswe_0019_id, titleRes = R.string.maswe_0019_title, route = Maswe0019AuthRoute, icon = Icons.Default.VpnKey),
            MasweItem(idRes = R.string.maswe_0020_id, titleRes = R.string.maswe_0020_title, route = Maswe0020AuthRoute, icon = Icons.Default.Fingerprint),
            MasweItem(idRes = R.string.maswe_0021_id, titleRes = R.string.maswe_0021_title, route = Maswe0021AuthRoute, icon = Icons.Default.NoEncryption),
            MasweItem(idRes = R.string.maswe_0022_id, titleRes = R.string.maswe_0022_title, route = Maswe0022AuthRoute, icon = Icons.Default.Key),
            MasweItem(idRes = R.string.maswe_0023_id, titleRes = R.string.maswe_0023_title, route = Maswe0023AuthRoute, icon = Icons.Default.Lock),
            MasweItem(idRes = R.string.maswe_0024_id, titleRes = R.string.maswe_0024_title, route = Maswe0024AuthRoute, icon = Icons.AutoMirrored.Filled.ExitToApp),
            MasweItem(idRes = R.string.maswe_0025_id, titleRes = R.string.maswe_0025_title, route = Maswe0025AuthRoute, icon = Icons.Default.Verified)
        )
    ),
    PLATFORM(
        titleRes = R.string.masvs_platform,
        items = listOf(
            MasweItem(idRes = R.string.maswe_0029_id, titleRes = R.string.maswe_0029_title, route = Maswe0029PlatformRoute, icon = Icons.Default.Link),
            MasweItem(idRes = R.string.maswe_0030_id, titleRes = R.string.maswe_0030_title, route = Maswe0030PlatformRoute, icon = Icons.Default.ContentCopy),
            MasweItem(idRes = R.string.maswe_0031_id, titleRes = R.string.maswe_0031_title, route = Maswe0031PlatformRoute, icon = Icons.Default.Extension),
            MasweItem(idRes = R.string.maswe_0032_id, titleRes = R.string.maswe_0032_title, route = Maswe0032PlatformRoute, icon = Icons.Default.Send),
            MasweItem(idRes = R.string.maswe_0033_id, titleRes = R.string.maswe_0033_title, route = Maswe0033PlatformRoute, icon = Icons.Default.Language),
            MasweItem(idRes = R.string.maswe_0034_id, titleRes = R.string.maswe_0034_title, route = Maswe0034PlatformRoute, icon = Icons.Default.FolderOpen),
            MasweItem(idRes = R.string.maswe_0035_id, titleRes = R.string.maswe_0035_title, route = Maswe0035PlatformRoute, icon = Icons.Default.Explore),
            MasweItem(idRes = R.string.maswe_0036_id, titleRes = R.string.maswe_0036_title, route = Maswe0036PlatformRoute, icon = Icons.Default.Visibility),
            MasweItem(idRes = R.string.maswe_0037_id, titleRes = R.string.maswe_0037_title, route = Maswe0037PlatformRoute, icon = Icons.Default.Notifications),
            MasweItem(idRes = R.string.maswe_0038_id, titleRes = R.string.maswe_0038_title, route = Maswe0038PlatformRoute, icon = Icons.Default.Screenshot),
            MasweItem(idRes = R.string.maswe_0039_id, titleRes = R.string.maswe_0039_title, route = Maswe0039PlatformRoute, icon = Icons.Default.Layers),
            MasweItem(idRes = R.string.maswe_0040_id, titleRes = R.string.maswe_0040_title, route = Maswe0040PlatformRoute, icon = Icons.Default.Accessibility)
        )
    ),
    CODE(
        titleRes = R.string.masvs_code,
        items = listOf(
            MasweItem(idRes = R.string.maswe_0041_id, titleRes = R.string.maswe_0041_title, route = Maswe0041CodeRoute, icon = Icons.Default.DeviceUnknown),
            MasweItem(idRes = R.string.maswe_0042_id, titleRes = R.string.maswe_0042_title, route = Maswe0042CodeRoute, icon = Icons.Default.SystemUpdate),
            MasweItem(idRes = R.string.maswe_0043_id, titleRes = R.string.maswe_0043_title, route = Maswe0043CodeRoute, icon = Icons.Default.SystemUpdateAlt),
            MasweItem(idRes = R.string.maswe_0044_id, titleRes = R.string.maswe_0044_title, route = Maswe0044CodeRoute, icon = Icons.Default.LibraryBooks),
            MasweItem(idRes = R.string.maswe_0045_id, titleRes = R.string.maswe_0045_title, route = Maswe0045CodeRoute, icon = Icons.Default.Memory),
            MasweItem(idRes = R.string.maswe_0046_id, titleRes = R.string.maswe_0046_title, route = Maswe0046CodeRoute, icon = Icons.Default.NoEncryption),
            MasweItem(idRes = R.string.maswe_0047_id, titleRes = R.string.maswe_0047_title, route = Maswe0047CodeRoute, icon = Icons.Default.SettingsEthernet),
            MasweItem(idRes = R.string.maswe_0048_id, titleRes = R.string.maswe_0048_title, route = Maswe0048CodeRoute, icon = Icons.Default.PersonOff),
            MasweItem(idRes = R.string.maswe_0049_id, titleRes = R.string.maswe_0049_title, route = Maswe0049CodeRoute, icon = Icons.Default.Apps),
            MasweItem(idRes = R.string.maswe_0050_id, titleRes = R.string.maswe_0050_title, route = Maswe0050CodeRoute, icon = Icons.Default.Rule)
        )
    ),
    RESILIENCE(
        titleRes = R.string.masvs_resilience,
        items = listOf(
            MasweItem(idRes = R.string.maswe_0051_id, titleRes = R.string.maswe_0051_title, route = Maswe0051ResilienceRoute, icon = Icons.Default.DeviceUnknown),
            MasweItem(idRes = R.string.maswe_0052_id, titleRes = R.string.maswe_0052_title, route = Maswe0052ResilienceRoute, icon = Icons.Default.LaptopWindows),
            MasweItem(idRes = R.string.maswe_0053_id, titleRes = R.string.maswe_0053_title, route = Maswe0053ResilienceRoute, icon = Icons.Default.Android),
            MasweItem(idRes = R.string.maswe_0054_id, titleRes = R.string.maswe_0054_title, route = Maswe0054ResilienceRoute, icon = Icons.Default.VerifiedUser),
            MasweItem(idRes = R.string.maswe_0055_id, titleRes = R.string.maswe_0055_title, route = Maswe0055ResilienceRoute, icon = Icons.Default.PestControl),
            MasweItem(idRes = R.string.maswe_0056_id, titleRes = R.string.maswe_0056_title, route = Maswe0056ResilienceRoute, icon = Icons.Default.Verified),
            MasweItem(idRes = R.string.maswe_0057_id, titleRes = R.string.maswe_0057_title, route = Maswe0057ResilienceRoute, icon = Icons.Default.FolderOpen),
            MasweItem(idRes = R.string.maswe_0058_id, titleRes = R.string.maswe_0058_title, route = Maswe0058ResilienceRoute, icon = Icons.Default.Memory),
            MasweItem(idRes = R.string.maswe_0059_id, titleRes = R.string.maswe_0059_title, route = Maswe0059ResilienceRoute, icon = Icons.Default.CodeOff),
            MasweItem(idRes = R.string.maswe_0060_id, titleRes = R.string.maswe_0060_title, route = Maswe0060ResilienceRoute, icon = Icons.Default.Image),
            MasweItem(idRes = R.string.maswe_0061_id, titleRes = R.string.maswe_0061_title, route = Maswe0061ResilienceRoute, icon = Icons.Default.BugReport),
            MasweItem(idRes = R.string.maswe_0062_id, titleRes = R.string.maswe_0062_title, route = Maswe0062ResilienceRoute, icon = Icons.Default.VpnKey),
            MasweItem(idRes = R.string.maswe_0063_id, titleRes = R.string.maswe_0063_title, route = Maswe0063ResilienceRoute, icon = Icons.Default.BuildCircle),
            MasweItem(idRes = R.string.maswe_0064_id, titleRes = R.string.maswe_0064_title, route = Maswe0064ResilienceRoute, icon = Icons.Default.PestControl),
            MasweItem(idRes = R.string.maswe_0065_id, titleRes = R.string.maswe_0065_title, route = Maswe0065ResilienceRoute, icon = Icons.Default.AutoFixOff)
        )
    ),
    PRIVACY(
        titleRes = R.string.masvs_privacy,
        items = listOf(
            MasweItem(idRes = R.string.maswe_0066_id, titleRes = R.string.maswe_0066_title, route = Maswe0066PrivacyRoute, icon = Icons.Default.Security),
            MasweItem(idRes = R.string.maswe_0067_id, titleRes = R.string.maswe_0067_title, route = Maswe0067PrivacyRoute, icon = Icons.Default.Keyboard),
            MasweItem(idRes = R.string.maswe_0068_id, titleRes = R.string.maswe_0068_title, route = Maswe0068PrivacyRoute, icon = Icons.Default.Visibility),
            MasweItem(idRes = R.string.maswe_0069_id, titleRes = R.string.maswe_0069_title, route = Maswe0069PrivacyRoute, icon = Icons.Default.ContentCopy),
            MasweItem(idRes = R.string.maswe_0070_id, titleRes = R.string.maswe_0070_title, route = Maswe0070PrivacyRoute, icon = Icons.Default.Share),
            MasweItem(idRes = R.string.maswe_0071_id, titleRes = R.string.maswe_0071_title, route = Maswe0071PrivacyRoute, icon = Icons.Default.Settings),
            MasweItem(idRes = R.string.maswe_0072_id, titleRes = R.string.maswe_0072_title, route = Maswe0072PrivacyRoute, icon = Icons.Default.Policy),
            MasweItem(idRes = R.string.maswe_0073_id, titleRes = R.string.maswe_0073_title, route = Maswe0073PrivacyRoute, icon = Icons.Default.DataUsage),
            MasweItem(idRes = R.string.maswe_0074_id, titleRes = R.string.maswe_0074_title, route = Maswe0074PrivacyRoute, icon = Icons.Default.Language),
            MasweItem(idRes = R.string.maswe_0075_id, titleRes = R.string.maswe_0075_title, route = Maswe0075PrivacyRoute, icon = Icons.Default.Build),
            MasweItem(idRes = R.string.maswe_0076_id, titleRes = R.string.maswe_0076_title, route = Maswe0076PrivacyRoute, icon = Icons.Default.Storage),
            MasweItem(idRes = R.string.maswe_0077_id, titleRes = R.string.maswe_0077_title, route = Maswe0077PrivacyRoute, icon = Icons.Default.VisibilityOff),
            MasweItem(idRes = R.string.maswe_0078_id, titleRes = R.string.maswe_0078_title, route = Maswe0078PrivacyRoute, icon = Icons.Default.FactCheck)
        )
    )
}

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
            items(MasvsCategory.values()) { category ->
                MasvsCategoryAccordion(category, onNavigate, onOpenDocumentation)
            }
        }
    }
}

@Composable
fun MasvsCategoryAccordion(
    category: MasvsCategory, 
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
                                .clickable {
                                    if (item.route != null) {
                                        onNavigate(item.route)
                                    } else {
                                        android.widget.Toast.makeText(context, "Coming Soon!", android.widget.Toast.LENGTH_SHORT).show()
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
                            // DOCS Button for Documentation
                            if (item.idRes != 0) {
                                val masweIdStr = stringResource(id = item.idRes)
                                OutlinedButton(
                                    onClick = { onOpenDocumentation(masweIdStr) },
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
                                    modifier = Modifier.height(32.dp)
                                ) {
                                    Text(
                                        text = "DOCS",
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
