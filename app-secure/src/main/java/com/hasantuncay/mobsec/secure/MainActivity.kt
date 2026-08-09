package com.hasantuncay.mobsec.secure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.data.LocalMasterclassViewModel
import com.hasantuncay.mobsec.common.navigation.DashboardRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0005LogRoute
import com.hasantuncay.mobsec.common.ui.DashboardScreen
import com.hasantuncay.mobsec.common.ui.theme.AndroidSecurityMasterclassTheme
import com.hasantuncay.mobsec.common.ui.theme.AppType
import com.hasantuncay.mobsec.common.viewmodel.MasterclassDataViewModel
import com.hasantuncay.mobsec.secure.storage.maswe0005.Maswe0005LogSecureScreen
import com.hasantuncay.mobsec.secure.storage.maswe0001.Maswe0001StorageSecureScreen
import com.hasantuncay.mobsec.secure.storage.maswe0002.Maswe0002StorageSecureScreen
import com.hasantuncay.mobsec.common.navigation.Maswe0001StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0002StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0003StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0004StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0006StorageRoute
import com.hasantuncay.mobsec.common.navigation.MasweDocRoute
import com.hasantuncay.mobsec.common.ui.MasweDocScreen
import com.hasantuncay.mobsec.common.navigation.DataVaultRoute
import com.hasantuncay.mobsec.common.ui.DataVaultScreen
import com.hasantuncay.mobsec.secure.storage.maswe0003.Maswe0003StorageSecureScreen
import com.hasantuncay.mobsec.secure.storage.maswe0004.Maswe0004StorageSecureScreen
import com.hasantuncay.mobsec.secure.storage.maswe0006.Maswe0006StorageSecureScreen
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
import com.hasantuncay.mobsec.secure.crypto.maswe0007.Maswe0007CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0008.Maswe0008CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0009.Maswe0009CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0010.Maswe0010CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0011.Maswe0011CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0012.Maswe0012CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0013.Maswe0013CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0014.Maswe0014CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0015.Maswe0015CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0016.Maswe0016CryptoSecureScreen
import com.hasantuncay.mobsec.secure.crypto.maswe0017.Maswe0017CryptoSecureScreen
import com.hasantuncay.mobsec.common.navigation.Maswe0018AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0019AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0020AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0021AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0022AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0023AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0024AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0025AuthRoute
import com.hasantuncay.mobsec.secure.auth.maswe0018.Maswe0018AuthSecureScreen
import com.hasantuncay.mobsec.secure.auth.maswe0019.Maswe0019AuthSecureScreen
import com.hasantuncay.mobsec.secure.auth.maswe0020.Maswe0020AuthSecureScreen
import com.hasantuncay.mobsec.secure.auth.maswe0021.Maswe0021AuthSecureScreen
import com.hasantuncay.mobsec.secure.auth.maswe0022.Maswe0022AuthSecureScreen
import com.hasantuncay.mobsec.secure.auth.maswe0023.Maswe0023AuthSecureScreen
import com.hasantuncay.mobsec.secure.auth.maswe0024.Maswe0024AuthSecureScreen
import com.hasantuncay.mobsec.secure.auth.maswe0025.Maswe0025AuthSecureScreen
import com.hasantuncay.mobsec.common.navigation.Maswe0026NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0027NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0028NetworkRoute
import com.hasantuncay.mobsec.secure.network.maswe0026.Maswe0026NetworkSecureScreen
import com.hasantuncay.mobsec.secure.network.maswe0027.Maswe0027NetworkSecureScreen
import com.hasantuncay.mobsec.secure.network.maswe0028.Maswe0028NetworkSecureScreen
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
import com.hasantuncay.mobsec.secure.platform.maswe0029.Maswe0029PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0030.Maswe0030PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0031.Maswe0031PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0032.Maswe0032PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0033.Maswe0033PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0034.Maswe0034PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0035.Maswe0035PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0036.Maswe0036PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0037.Maswe0037PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0038.Maswe0038PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0039.Maswe0039PlatformSecureScreen
import com.hasantuncay.mobsec.secure.platform.maswe0040.Maswe0040PlatformSecureScreen
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
import com.hasantuncay.mobsec.secure.code.maswe0041.Maswe0041CodeSecureScreen
import com.hasantuncay.mobsec.secure.code.maswe0042.Maswe0042CodeSecureScreen
import com.hasantuncay.mobsec.secure.code.maswe0043.Maswe0043CodeSecureScreen
import com.hasantuncay.mobsec.secure.code.maswe0044.Maswe0044CodeSecureScreen
import com.hasantuncay.mobsec.secure.code.maswe0045.Maswe0045CodeSecureScreen
import com.hasantuncay.mobsec.secure.code.maswe0046.Maswe0046CodeSecureScreen
import com.hasantuncay.mobsec.secure.code.maswe0047.Maswe0047CodeSecureScreen
import com.hasantuncay.mobsec.secure.code.maswe0048.Maswe0048CodeSecureScreen
import com.hasantuncay.mobsec.secure.code.maswe0049.Maswe0049CodeSecureScreen
import com.hasantuncay.mobsec.secure.code.maswe0050.Maswe0050CodeSecureScreen
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
import com.hasantuncay.mobsec.secure.resilience.maswe0051.Maswe0051ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0052.Maswe0052ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0053.Maswe0053ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0054.Maswe0054ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0055.Maswe0055ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0056.Maswe0056ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0057.Maswe0057ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0058.Maswe0058ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0059.Maswe0059ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0060.Maswe0060ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0061.Maswe0061ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0062.Maswe0062ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0063.Maswe0063ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0064.Maswe0064ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.resilience.maswe0065.Maswe0065ResilienceSecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0066.Maswe0066PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0067.Maswe0067PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0068.Maswe0068PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0069.Maswe0069PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0070.Maswe0070PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0071.Maswe0071PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0072.Maswe0072PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0073.Maswe0073PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0074.Maswe0074PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0075.Maswe0075PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0076.Maswe0076PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0077.Maswe0077PrivacySecureScreen
import com.hasantuncay.mobsec.secure.privacy.maswe0078.Maswe0078PrivacySecureScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val masterclassViewModel: MasterclassDataViewModel = viewModel()

            CompositionLocalProvider(LocalMasterclassViewModel provides masterclassViewModel) {
                AndroidSecurityMasterclassTheme(appType = AppType.SECURE) {
                    SecureApp()
                }
            }
        }
    }
}

@Composable
fun SecureApp() {
    val backStack = remember { mutableStateListOf<Any>(DashboardRoute) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<DashboardRoute> {
                DashboardScreen(
                    title = stringResource(R.string.dashboard_title_secure),
                    onNavigate = { route -> backStack.add(route) },
                    onOpenDocumentation = { masweId -> backStack.add(MasweDocRoute(masweId)) }
                )
            }
            entry<Maswe0005LogRoute> {
                Maswe0005LogSecureScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0001StorageRoute> {
                Maswe0001StorageSecureScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0002StorageRoute> {
                Maswe0002StorageSecureScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0003StorageRoute> {
                Maswe0003StorageSecureScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0004StorageRoute> {
                Maswe0004StorageSecureScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0006StorageRoute> {
                Maswe0006StorageSecureScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0007CryptoRoute> { Maswe0007CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0008CryptoRoute> { Maswe0008CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0009CryptoRoute> { Maswe0009CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0010CryptoRoute> { Maswe0010CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0011CryptoRoute> { Maswe0011CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0012CryptoRoute> { Maswe0012CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0013CryptoRoute> { Maswe0013CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0014CryptoRoute> { Maswe0014CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0015CryptoRoute> { Maswe0015CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0016CryptoRoute> { Maswe0016CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0017CryptoRoute> { Maswe0017CryptoSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0018AuthRoute> { Maswe0018AuthSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0019AuthRoute> { Maswe0019AuthSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0020AuthRoute> { Maswe0020AuthSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0021AuthRoute> { Maswe0021AuthSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0022AuthRoute> { Maswe0022AuthSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0023AuthRoute> { Maswe0023AuthSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0024AuthRoute> { Maswe0024AuthSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0025AuthRoute> { Maswe0025AuthSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0026NetworkRoute> { Maswe0026NetworkSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0027NetworkRoute> { Maswe0027NetworkSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0028NetworkRoute> { Maswe0028NetworkSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0029PlatformRoute> { Maswe0029PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0030PlatformRoute> { Maswe0030PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0031PlatformRoute> { Maswe0031PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0032PlatformRoute> { Maswe0032PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0033PlatformRoute> { Maswe0033PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0034PlatformRoute> { Maswe0034PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0035PlatformRoute> { Maswe0035PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0036PlatformRoute> { Maswe0036PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0037PlatformRoute> { Maswe0037PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0038PlatformRoute> { Maswe0038PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0039PlatformRoute> { Maswe0039PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0040PlatformRoute> { Maswe0040PlatformSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0041CodeRoute> { Maswe0041CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0042CodeRoute> { Maswe0042CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0043CodeRoute> { Maswe0043CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0044CodeRoute> { Maswe0044CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0045CodeRoute> { Maswe0045CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0046CodeRoute> { Maswe0046CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0047CodeRoute> { Maswe0047CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0048CodeRoute> { Maswe0048CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0049CodeRoute> { Maswe0049CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0050CodeRoute> { Maswe0050CodeSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0051ResilienceRoute> { Maswe0051ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0052ResilienceRoute> { Maswe0052ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0053ResilienceRoute> { Maswe0053ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0054ResilienceRoute> { Maswe0054ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0055ResilienceRoute> { Maswe0055ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0056ResilienceRoute> { Maswe0056ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0057ResilienceRoute> { Maswe0057ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0058ResilienceRoute> { Maswe0058ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0059ResilienceRoute> { Maswe0059ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0060ResilienceRoute> { Maswe0060ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0061ResilienceRoute> { Maswe0061ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0062ResilienceRoute> { Maswe0062ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0063ResilienceRoute> { Maswe0063ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0064ResilienceRoute> { Maswe0064ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0065ResilienceRoute> { Maswe0065ResilienceSecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0066PrivacyRoute> { Maswe0066PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0067PrivacyRoute> { Maswe0067PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0068PrivacyRoute> { Maswe0068PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0069PrivacyRoute> { Maswe0069PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0070PrivacyRoute> { Maswe0070PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0071PrivacyRoute> { Maswe0071PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0072PrivacyRoute> { Maswe0072PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0073PrivacyRoute> { Maswe0073PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0074PrivacyRoute> { Maswe0074PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0075PrivacyRoute> { Maswe0075PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0076PrivacyRoute> { Maswe0076PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0077PrivacyRoute> { Maswe0077PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0078PrivacyRoute> { Maswe0078PrivacySecureScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<MasweDocRoute> { route ->
                MasweDocScreen(
                    masweId = route.masweId,
                    onBack = { backStack.removeLastOrNull() }
                )
            }
            entry<DataVaultRoute> {
                DataVaultScreen(onBack = { backStack.removeLastOrNull() })
            }
        }
    )
}