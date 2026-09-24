package com.hasantuncay.mobsec.common.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.hasantuncay.mobsec.common.navigation.*
import com.hasantuncay.mobsec.common.R


data class MasweItemData(
    val meta: MasweScreenMeta,
    val route: Any?,
    val icon: ImageVector = Icons.Default.BugReport
)

data class MasvsCategoryData(
    val titleRes: Int,
    val items: List<MasweItemData>
)

object DashboardRegistry {
    val categories = listOf(
        MasvsCategoryData(
            titleRes = R.string.masvs_storage,
            items = listOf(
                MasweItemData(MasweScreenMeta("MASWE-0001", R.string.maswe_0001_title, R.string.maswe_0001_desc, R.string.maswe_context_info, R.string.maswe_0001_vectors_title), Maswe0001StorageRoute, Icons.Default.NoEncryption),
                MasweItemData(MasweScreenMeta("MASWE-0002", R.string.maswe_0002_title, R.string.maswe_0002_desc, R.string.maswe_context_info, R.string.maswe_0002_vectors_title), Maswe0002StorageRoute, Icons.Default.FolderShared),
                MasweItemData(MasweScreenMeta("MASWE-0003", R.string.maswe_0003_title, R.string.maswe_0003_desc, R.string.maswe_context_info, R.string.maswe_0003_vectors_title), Maswe0003StorageRoute, Icons.Default.CloudSync),
                MasweItemData(MasweScreenMeta("MASWE-0004", R.string.maswe_0004_title, R.string.maswe_0004_desc, R.string.maswe_context_info, R.string.maswe_0004_vectors_title), Maswe0004StorageRoute, Icons.Default.CloudOff),
                MasweItemData(MasweScreenMeta("MASWE-0005", R.string.maswe_0005_title, R.string.maswe_0005_desc, R.string.maswe_context_info, R.string.maswe_0005_vectors_title), Maswe0005LogRoute, Icons.Default.DataArray),
                MasweItemData(MasweScreenMeta("MASWE-0006", R.string.maswe_0006_title, R.string.maswe_0006_desc, R.string.maswe_context_info, R.string.maswe_0006_vectors_title), Maswe0006StorageRoute, Icons.Default.FolderSpecial)
            )
        ),
        MasvsCategoryData(
            titleRes = R.string.masvs_crypto,
            items = listOf(
                MasweItemData(MasweScreenMeta("MASWE-0007", R.string.maswe_0007_title, R.string.maswe_0007_desc, R.string.maswe_context_info, R.string.maswe_0007_vectors_title), Maswe0007CryptoRoute, Icons.Default.NoEncryption),
                MasweItemData(MasweScreenMeta("MASWE-0008", R.string.maswe_0008_title, R.string.maswe_0008_desc, R.string.maswe_context_info, R.string.maswe_0008_vectors_title), Maswe0008CryptoRoute, Icons.Default.DataArray),
                MasweItemData(MasweScreenMeta("MASWE-0009", R.string.maswe_0009_title, R.string.maswe_0009_desc, R.string.maswe_context_info, R.string.maswe_0009_vectors_title), Maswe0009CryptoRoute, Icons.Default.DataObject),
                MasweItemData(MasweScreenMeta("MASWE-0010", R.string.maswe_0010_title, R.string.maswe_0010_desc, R.string.maswe_context_info, R.string.maswe_0010_vectors_title), Maswe0010CryptoRoute, Icons.Default.Build),
                MasweItemData(MasweScreenMeta("MASWE-0011", R.string.maswe_0011_title, R.string.maswe_0011_desc, R.string.maswe_context_info, R.string.maswe_0011_vectors_title), Maswe0011CryptoRoute, Icons.Default.BugReport),
                MasweItemData(MasweScreenMeta("MASWE-0012", R.string.maswe_0012_title, R.string.maswe_0012_desc, R.string.maswe_context_info, R.string.maswe_0012_vectors_title), Maswe0012CryptoRoute, Icons.Default.FolderSpecial),
                MasweItemData(MasweScreenMeta("MASWE-0013", R.string.maswe_0013_title, R.string.maswe_0013_desc, R.string.maswe_context_info, R.string.maswe_0013_vectors_title), Maswe0013CryptoRoute, Icons.Default.CloudOff),
                MasweItemData(MasweScreenMeta("MASWE-0014", R.string.maswe_0014_title, R.string.maswe_0014_desc, R.string.maswe_context_info, R.string.maswe_0014_vectors_title), Maswe0014CryptoRoute, Icons.Default.FolderShared),
                MasweItemData(MasweScreenMeta("MASWE-0015", R.string.maswe_0015_title, R.string.maswe_0015_desc, R.string.maswe_context_info, R.string.maswe_0015_vectors_title), Maswe0015CryptoRoute, Icons.Default.CloudSync),
                MasweItemData(MasweScreenMeta("MASWE-0016", R.string.maswe_0016_title, R.string.maswe_0016_desc, R.string.maswe_context_info, R.string.maswe_0016_vectors_title), Maswe0016CryptoRoute, Icons.Default.Lock),
                MasweItemData(MasweScreenMeta("MASWE-0017", R.string.maswe_0017_title, R.string.maswe_0017_desc, R.string.maswe_context_info, R.string.maswe_0017_vectors_title), Maswe0017CryptoRoute, Icons.Default.NoEncryption)
            )
        ),
        MasvsCategoryData(
            titleRes = R.string.masvs_network,
            items = listOf(
                MasweItemData(MasweScreenMeta("MASWE-0026", R.string.maswe_0026_title, R.string.maswe_0026_desc, R.string.maswe_context_info, R.string.maswe_0026_vectors_title), Maswe0026NetworkRoute, Icons.Default.NoEncryption),
                MasweItemData(MasweScreenMeta("MASWE-0027", R.string.maswe_0027_title, R.string.maswe_0027_desc, R.string.maswe_context_info, R.string.maswe_0027_vectors_title), Maswe0027NetworkRoute, Icons.Default.Block),
                MasweItemData(MasweScreenMeta("MASWE-0028", R.string.maswe_0028_title, R.string.maswe_0028_desc, R.string.maswe_context_info, R.string.maswe_0028_vectors_title), Maswe0028NetworkRoute, Icons.Default.BugReport)
            )
        ),
        MasvsCategoryData(
            titleRes = R.string.masvs_auth,
            items = listOf(
                MasweItemData(MasweScreenMeta("MASWE-0018", R.string.maswe_0018_title, R.string.maswe_0018_desc, R.string.maswe_context_info, R.string.maswe_0018_vectors_title), Maswe0018AuthRoute, Icons.Default.Security),
                MasweItemData(MasweScreenMeta("MASWE-0019", R.string.maswe_0019_title, R.string.maswe_0019_desc, R.string.maswe_context_info, R.string.maswe_0019_vectors_title), Maswe0019AuthRoute, Icons.Default.VpnKey),
                MasweItemData(MasweScreenMeta("MASWE-0020", R.string.maswe_0020_title, R.string.maswe_0020_desc, R.string.maswe_context_info, R.string.maswe_0020_vectors_title), Maswe0020AuthRoute, Icons.Default.Fingerprint),
                MasweItemData(MasweScreenMeta("MASWE-0021", R.string.maswe_0021_title, R.string.maswe_0021_desc, R.string.maswe_context_info, R.string.maswe_0021_vectors_title), Maswe0021AuthRoute, Icons.Default.NoEncryption),
                MasweItemData(MasweScreenMeta("MASWE-0022", R.string.maswe_0022_title, R.string.maswe_0022_desc, R.string.maswe_context_info, R.string.maswe_0022_vectors_title), Maswe0022AuthRoute, Icons.Default.Key),
                MasweItemData(MasweScreenMeta("MASWE-0023", R.string.maswe_0023_title, R.string.maswe_0023_desc, R.string.maswe_context_info, R.string.maswe_0023_vectors_title), Maswe0023AuthRoute, Icons.Default.Lock),
                MasweItemData(MasweScreenMeta("MASWE-0024", R.string.maswe_0024_title, R.string.maswe_0024_desc, R.string.maswe_context_info, R.string.maswe_0024_vectors_title), Maswe0024AuthRoute, Icons.AutoMirrored.Filled.ExitToApp),
                MasweItemData(MasweScreenMeta("MASWE-0025", R.string.maswe_0025_title, R.string.maswe_0025_desc, R.string.maswe_context_info, R.string.maswe_0025_vectors_title), Maswe0025AuthRoute, Icons.Default.Verified)
            )
        ),
        MasvsCategoryData(
            titleRes = R.string.masvs_platform,
            items = listOf(
                MasweItemData(MasweScreenMeta("MASWE-0029", R.string.maswe_0029_title, R.string.maswe_0029_desc, R.string.maswe_context_info, R.string.maswe_0029_vectors_title), Maswe0029PlatformRoute, Icons.Default.Link),
                MasweItemData(MasweScreenMeta("MASWE-0030", R.string.maswe_0030_title, R.string.maswe_0030_desc, R.string.maswe_context_info, R.string.maswe_0030_vectors_title), Maswe0030PlatformRoute, Icons.Default.ContentCopy),
                MasweItemData(MasweScreenMeta("MASWE-0031", R.string.maswe_0031_title, R.string.maswe_0031_desc, R.string.maswe_context_info, R.string.maswe_0031_vectors_title), Maswe0031PlatformRoute, Icons.Default.Extension),
                MasweItemData(MasweScreenMeta("MASWE-0032", R.string.maswe_0032_title, R.string.maswe_0032_desc, R.string.maswe_context_info, R.string.maswe_0032_vectors_title), Maswe0032PlatformRoute, Icons.AutoMirrored.Filled.Send),
                MasweItemData(MasweScreenMeta("MASWE-0033", R.string.maswe_0033_title, R.string.maswe_0033_desc, R.string.maswe_context_info, R.string.maswe_0033_vectors_title), Maswe0033PlatformRoute, Icons.Default.Language),
                MasweItemData(MasweScreenMeta("MASWE-0034", R.string.maswe_0034_title, R.string.maswe_0034_desc, R.string.maswe_context_info, R.string.maswe_0034_vectors_title), Maswe0034PlatformRoute, Icons.Default.FolderOpen),
                MasweItemData(MasweScreenMeta("MASWE-0035", R.string.maswe_0035_title, R.string.maswe_0035_desc, R.string.maswe_context_info, R.string.maswe_0035_vectors_title), Maswe0035PlatformRoute, Icons.Default.Explore),
                MasweItemData(MasweScreenMeta("MASWE-0036", R.string.maswe_0036_title, R.string.maswe_0036_desc, R.string.maswe_context_info, R.string.maswe_0036_vectors_title), Maswe0036PlatformRoute, Icons.Default.Visibility),
                MasweItemData(MasweScreenMeta("MASWE-0037", R.string.maswe_0037_title, R.string.maswe_0037_desc, R.string.maswe_context_info, R.string.maswe_0037_vectors_title), Maswe0037PlatformRoute, Icons.Default.Notifications),
                MasweItemData(MasweScreenMeta("MASWE-0038", R.string.maswe_0038_title, R.string.maswe_0038_desc, R.string.maswe_context_info, R.string.maswe_0038_vectors_title), Maswe0038PlatformRoute, Icons.Default.Screenshot),
                MasweItemData(MasweScreenMeta("MASWE-0039", R.string.maswe_0039_title, R.string.maswe_0039_desc, R.string.maswe_context_info, R.string.maswe_0039_vectors_title), Maswe0039PlatformRoute, Icons.Default.Layers),
                MasweItemData(MasweScreenMeta("MASWE-0040", R.string.maswe_0040_title, R.string.maswe_0040_desc, R.string.maswe_context_info, R.string.maswe_0040_vectors_title), Maswe0040PlatformRoute, Icons.Default.Accessibility)
            )
        ),
        MasvsCategoryData(
            titleRes = R.string.masvs_code,
            items = listOf(
                MasweItemData(MasweScreenMeta("MASWE-0041", R.string.maswe_0041_title, R.string.maswe_0041_desc, R.string.maswe_context_info, R.string.maswe_0041_vectors_title), Maswe0041CodeRoute, Icons.Default.DeviceUnknown),
                MasweItemData(MasweScreenMeta("MASWE-0042", R.string.maswe_0042_title, R.string.maswe_0042_desc, R.string.maswe_context_info, R.string.maswe_0042_vectors_title), Maswe0042CodeRoute, Icons.Default.SystemUpdate),
                MasweItemData(MasweScreenMeta("MASWE-0043", R.string.maswe_0043_title, R.string.maswe_0043_desc, R.string.maswe_context_info, R.string.maswe_0043_vectors_title), Maswe0043CodeRoute, Icons.Default.SystemUpdateAlt),
                MasweItemData(MasweScreenMeta("MASWE-0044", R.string.maswe_0044_title, R.string.maswe_0044_desc, R.string.maswe_context_info, R.string.maswe_0044_vectors_title), Maswe0044CodeRoute, Icons.AutoMirrored.Filled.LibraryBooks),
                MasweItemData(MasweScreenMeta("MASWE-0045", R.string.maswe_0045_title, R.string.maswe_0045_desc, R.string.maswe_context_info, R.string.maswe_0045_vectors_title), Maswe0045CodeRoute, Icons.Default.Memory),
                MasweItemData(MasweScreenMeta("MASWE-0046", R.string.maswe_0046_title, R.string.maswe_0046_desc, R.string.maswe_context_info, R.string.maswe_0046_vectors_title), Maswe0046CodeRoute, Icons.Default.NoEncryption),
                MasweItemData(MasweScreenMeta("MASWE-0047", R.string.maswe_0047_title, R.string.maswe_0047_desc, R.string.maswe_context_info, R.string.maswe_0047_vectors_title), Maswe0047CodeRoute, Icons.Default.SettingsEthernet),
                MasweItemData(MasweScreenMeta("MASWE-0048", R.string.maswe_0048_title, R.string.maswe_0048_desc, R.string.maswe_context_info, R.string.maswe_0048_vectors_title), Maswe0048CodeRoute, Icons.Default.PersonOff),
                MasweItemData(MasweScreenMeta("MASWE-0049", R.string.maswe_0049_title, R.string.maswe_0049_desc, R.string.maswe_context_info, R.string.maswe_0049_vectors_title), Maswe0049CodeRoute, Icons.Default.Apps),
                MasweItemData(MasweScreenMeta("MASWE-0050", R.string.maswe_0050_title, R.string.maswe_0050_desc, R.string.maswe_context_info, R.string.maswe_0050_vectors_title), Maswe0050CodeRoute, Icons.AutoMirrored.Filled.Rule)
            )
        ),
        MasvsCategoryData(
            titleRes = R.string.masvs_resilience,
            items = listOf(
                MasweItemData(MasweScreenMeta("MASWE-0051", R.string.maswe_0051_title, R.string.maswe_0051_desc, R.string.maswe_context_info, R.string.maswe_0051_vectors_title), Maswe0051ResilienceRoute, Icons.Default.DeviceUnknown),
                MasweItemData(MasweScreenMeta("MASWE-0052", R.string.maswe_0052_title, R.string.maswe_0052_desc, R.string.maswe_context_info, R.string.maswe_0052_vectors_title), Maswe0052ResilienceRoute, Icons.Default.LaptopWindows),
                MasweItemData(MasweScreenMeta("MASWE-0053", R.string.maswe_0053_title, R.string.maswe_0053_desc, R.string.maswe_context_info, R.string.maswe_0053_vectors_title), Maswe0053ResilienceRoute, Icons.Default.Android),
                MasweItemData(MasweScreenMeta("MASWE-0054", R.string.maswe_0054_title, R.string.maswe_0054_desc, R.string.maswe_context_info, R.string.maswe_0054_vectors_title), Maswe0054ResilienceRoute, Icons.Default.VerifiedUser),
                MasweItemData(MasweScreenMeta("MASWE-0055", R.string.maswe_0055_title, R.string.maswe_0055_desc, R.string.maswe_context_info, R.string.maswe_0055_vectors_title), Maswe0055ResilienceRoute, Icons.Default.PestControl),
                MasweItemData(MasweScreenMeta("MASWE-0056", R.string.maswe_0056_title, R.string.maswe_0056_desc, R.string.maswe_context_info, R.string.maswe_0056_vectors_title), Maswe0056ResilienceRoute, Icons.Default.Verified),
                MasweItemData(MasweScreenMeta("MASWE-0057", R.string.maswe_0057_title, R.string.maswe_0057_desc, R.string.maswe_context_info, R.string.maswe_0057_vectors_title), Maswe0057ResilienceRoute, Icons.Default.FolderOpen),
                MasweItemData(MasweScreenMeta("MASWE-0058", R.string.maswe_0058_title, R.string.maswe_0058_desc, R.string.maswe_context_info, R.string.maswe_0058_vectors_title), Maswe0058ResilienceRoute, Icons.Default.Memory),
                MasweItemData(MasweScreenMeta("MASWE-0059", R.string.maswe_0059_title, R.string.maswe_0059_desc, R.string.maswe_context_info, R.string.maswe_0059_vectors_title), Maswe0059ResilienceRoute, Icons.Default.CodeOff),
                MasweItemData(MasweScreenMeta("MASWE-0060", R.string.maswe_0060_title, R.string.maswe_0060_desc, R.string.maswe_context_info, R.string.maswe_0060_vectors_title), Maswe0060ResilienceRoute, Icons.Default.Image),
                MasweItemData(MasweScreenMeta("MASWE-0061", R.string.maswe_0061_title, R.string.maswe_0061_desc, R.string.maswe_context_info, R.string.maswe_0061_vectors_title), Maswe0061ResilienceRoute, Icons.Default.BugReport),
                MasweItemData(MasweScreenMeta("MASWE-0062", R.string.maswe_0062_title, R.string.maswe_0062_desc, R.string.maswe_context_info, R.string.maswe_0062_vectors_title), Maswe0062ResilienceRoute, Icons.Default.VpnKey),
                MasweItemData(MasweScreenMeta("MASWE-0063", R.string.maswe_0063_title, R.string.maswe_0063_desc, R.string.maswe_context_info, R.string.maswe_0063_vectors_title), Maswe0063ResilienceRoute, Icons.Default.BuildCircle),
                MasweItemData(MasweScreenMeta("MASWE-0064", R.string.maswe_0064_title, R.string.maswe_0064_desc, R.string.maswe_context_info, R.string.maswe_0064_vectors_title), Maswe0064ResilienceRoute, Icons.Default.PestControl),
                MasweItemData(MasweScreenMeta("MASWE-0065", R.string.maswe_0065_title, R.string.maswe_0065_desc, R.string.maswe_context_info, R.string.maswe_0065_vectors_title), Maswe0065ResilienceRoute, Icons.Default.AutoFixOff)
            )
        ),
        MasvsCategoryData(
            titleRes = R.string.masvs_privacy,
            items = listOf(
                MasweItemData(MasweScreenMeta("MASWE-0066", R.string.maswe_0066_title, R.string.maswe_0066_desc, R.string.maswe_context_info, R.string.maswe_0066_vectors_title), Maswe0066PrivacyRoute, Icons.Default.Security),
                MasweItemData(MasweScreenMeta("MASWE-0067", R.string.maswe_0067_title, R.string.maswe_0067_desc, R.string.maswe_context_info, R.string.maswe_0067_vectors_title), Maswe0067PrivacyRoute, Icons.Default.Keyboard),
                MasweItemData(MasweScreenMeta("MASWE-0068", R.string.maswe_0068_title, R.string.maswe_0068_desc, R.string.maswe_context_info, R.string.maswe_0068_vectors_title), Maswe0068PrivacyRoute, Icons.Default.Visibility),
                MasweItemData(MasweScreenMeta("MASWE-0069", R.string.maswe_0069_title, R.string.maswe_0069_desc, R.string.maswe_context_info, R.string.maswe_0069_vectors_title), Maswe0069PrivacyRoute, Icons.Default.ContentCopy),
                MasweItemData(MasweScreenMeta("MASWE-0070", R.string.maswe_0070_title, R.string.maswe_0070_desc, R.string.maswe_context_info, R.string.maswe_0070_vectors_title), Maswe0070PrivacyRoute, Icons.Default.Share),
                MasweItemData(MasweScreenMeta("MASWE-0071", R.string.maswe_0071_title, R.string.maswe_0071_desc, R.string.maswe_context_info, R.string.maswe_0071_vectors_title), Maswe0071PrivacyRoute, Icons.Default.Settings),
                MasweItemData(MasweScreenMeta("MASWE-0072", R.string.maswe_0072_title, R.string.maswe_0072_desc, R.string.maswe_context_info, R.string.maswe_0072_vectors_title), Maswe0072PrivacyRoute, Icons.Default.Policy),
                MasweItemData(MasweScreenMeta("MASWE-0073", R.string.maswe_0073_title, R.string.maswe_0073_desc, R.string.maswe_context_info, R.string.maswe_0073_vectors_title), Maswe0073PrivacyRoute, Icons.Default.DataUsage),
                MasweItemData(MasweScreenMeta("MASWE-0074", R.string.maswe_0074_title, R.string.maswe_0074_desc, R.string.maswe_context_info, R.string.maswe_0074_vectors_title), Maswe0074PrivacyRoute, Icons.Default.Language),
                MasweItemData(MasweScreenMeta("MASWE-0075", R.string.maswe_0075_title, R.string.maswe_0075_desc, R.string.maswe_context_info, R.string.maswe_0075_vectors_title), Maswe0075PrivacyRoute, Icons.Default.Build),
                MasweItemData(MasweScreenMeta("MASWE-0076", R.string.maswe_0076_title, R.string.maswe_0076_desc, R.string.maswe_context_info, R.string.maswe_0076_vectors_title), Maswe0076PrivacyRoute, Icons.Default.Storage),
                MasweItemData(MasweScreenMeta("MASWE-0077", R.string.maswe_0077_title, R.string.maswe_0077_desc, R.string.maswe_context_info, R.string.maswe_0077_vectors_title), Maswe0077PrivacyRoute, Icons.Default.VisibilityOff),
                MasweItemData(MasweScreenMeta("MASWE-0078", R.string.maswe_0078_title, R.string.maswe_0078_desc, R.string.maswe_context_info, R.string.maswe_0078_vectors_title), Maswe0078PrivacyRoute, Icons.AutoMirrored.Filled.FactCheck)
            )
        )
    )
}
