package com.hasantuncay.mobsec

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
import androidx.compose.ui.platform.LocalContext
import android.app.Activity
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.hasantuncay.mobsec.common.R
import com.hasantuncay.mobsec.common.models.data.LocalMasterclassViewModel
import com.hasantuncay.mobsec.common.navigation.DashboardRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0005LogRoute

import com.hasantuncay.mobsec.common.navigation.DataVaultRoute
import com.hasantuncay.mobsec.common.ui.DashboardScreen
import com.hasantuncay.mobsec.common.ui.DataVaultScreen
import com.hasantuncay.mobsec.common.ui.theme.AndroidSecurityMasterclassTheme
import com.hasantuncay.mobsec.common.ui.theme.AppType
import com.hasantuncay.mobsec.common.navigation.Maswe0001StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0002StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0003StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0004StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0006StorageRoute
import com.hasantuncay.mobsec.common.navigation.MasweDocRoute
import com.hasantuncay.mobsec.common.ui.MasweDocScreen
import com.hasantuncay.mobsec.common.viewmodel.MasterclassDataViewModel
import com.hasantuncay.mobsec.storage.maswe0001.Maswe0001StorageVulnerableScreen
import com.hasantuncay.mobsec.storage.maswe0002.Maswe0002StorageVulnerableScreen
import com.hasantuncay.mobsec.storage.maswe0003.Maswe0003StorageVulnerableScreen
import com.hasantuncay.mobsec.storage.maswe0004.Maswe0004StorageVulnerableScreen
import com.hasantuncay.mobsec.storage.maswe0005.Maswe0005LogVulnerableScreen
import com.hasantuncay.mobsec.storage.maswe0006.Maswe0006StorageVulnerableScreen
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
import com.hasantuncay.mobsec.crypto.maswe0007.Maswe0007CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0008.Maswe0008CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0009.Maswe0009CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0010.Maswe0010CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0011.Maswe0011CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0012.Maswe0012CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0013.Maswe0013CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0014.Maswe0014CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0015.Maswe0015CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0016.Maswe0016CryptoVulnerableScreen
import com.hasantuncay.mobsec.crypto.maswe0017.Maswe0017CryptoVulnerableScreen
import com.hasantuncay.mobsec.common.navigation.Maswe0018AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0019AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0020AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0021AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0022AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0023AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0024AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0025AuthRoute
import com.hasantuncay.mobsec.auth.maswe0018.Maswe0018AuthVulnerableScreen
import com.hasantuncay.mobsec.auth.maswe0019.Maswe0019AuthVulnerableScreen
import com.hasantuncay.mobsec.auth.maswe0020.Maswe0020AuthVulnerableScreen
import com.hasantuncay.mobsec.auth.maswe0021.Maswe0021AuthVulnerableScreen
import com.hasantuncay.mobsec.auth.maswe0022.Maswe0022AuthVulnerableScreen
import com.hasantuncay.mobsec.auth.maswe0023.Maswe0023AuthVulnerableScreen
import com.hasantuncay.mobsec.auth.maswe0024.Maswe0024AuthVulnerableScreen
import com.hasantuncay.mobsec.auth.maswe0025.Maswe0025AuthVulnerableScreen
import com.hasantuncay.mobsec.common.navigation.Maswe0026NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0027NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0028NetworkRoute
import com.hasantuncay.mobsec.network.maswe0026.Maswe0026NetworkVulnerableScreen
import com.hasantuncay.mobsec.network.maswe0027.Maswe0027NetworkVulnerableScreen
import com.hasantuncay.mobsec.network.maswe0028.Maswe0028NetworkVulnerableScreen
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
import com.hasantuncay.mobsec.platform.maswe0029.Maswe0029PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0030.Maswe0030PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0031.Maswe0031PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0032.Maswe0032PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0033.Maswe0033PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0034.Maswe0034PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0035.Maswe0035PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0036.Maswe0036PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0037.Maswe0037PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0038.Maswe0038PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0039.Maswe0039PlatformVulnerableScreen
import com.hasantuncay.mobsec.platform.maswe0040.Maswe0040PlatformVulnerableScreen
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
import com.hasantuncay.mobsec.code.maswe0041.Maswe0041CodeVulnerableScreen
import com.hasantuncay.mobsec.code.maswe0042.Maswe0042CodeVulnerableScreen
import com.hasantuncay.mobsec.code.maswe0043.Maswe0043CodeVulnerableScreen
import com.hasantuncay.mobsec.code.maswe0044.Maswe0044CodeVulnerableScreen
import com.hasantuncay.mobsec.code.maswe0045.Maswe0045CodeVulnerableScreen
import com.hasantuncay.mobsec.code.maswe0046.Maswe0046CodeVulnerableScreen
import com.hasantuncay.mobsec.code.maswe0047.Maswe0047CodeVulnerableScreen
import com.hasantuncay.mobsec.code.maswe0048.Maswe0048CodeVulnerableScreen
import com.hasantuncay.mobsec.code.maswe0049.Maswe0049CodeVulnerableScreen
import com.hasantuncay.mobsec.code.maswe0050.Maswe0050CodeVulnerableScreen
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
import com.hasantuncay.mobsec.resilience.maswe0051.Maswe0051ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0052.Maswe0052ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0053.Maswe0053ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0054.Maswe0054ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0055.Maswe0055ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0056.Maswe0056ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0057.Maswe0057ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0058.Maswe0058ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0059.Maswe0059ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0060.Maswe0060ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0061.Maswe0061ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0062.Maswe0062ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0063.Maswe0063ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0064.Maswe0064ResilienceVulnerableScreen
import com.hasantuncay.mobsec.resilience.maswe0065.Maswe0065ResilienceVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0066.Maswe0066PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0067.Maswe0067PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0068.Maswe0068PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0069.Maswe0069PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0070.Maswe0070PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0071.Maswe0071PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0072.Maswe0072PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0073.Maswe0073PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0074.Maswe0074PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0075.Maswe0075PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0076.Maswe0076PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0077.Maswe0077PrivacyVulnerableScreen
import com.hasantuncay.mobsec.privacy.maswe0078.Maswe0078PrivacyVulnerableScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val masterclassViewModel: MasterclassDataViewModel = viewModel()

            CompositionLocalProvider(LocalMasterclassViewModel provides masterclassViewModel) {
                AndroidSecurityMasterclassTheme(appType = AppType.VULNERABLE) {
                    SecurityApp()
                }
            }
        }
    }
}

@Composable
fun SecurityApp() {
    val context = LocalContext.current
    val backStack = remember { mutableStateListOf<Any>(DashboardRoute) }

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLastOrNull()
            } else {
                (context as? Activity)?.finish()
            }
        },
        entryProvider = entryProvider {
            entry<DashboardRoute> {
                DashboardScreen(
                    title = stringResource(R.string.dashboard_title_vulnerable),
                    onNavigate = { route -> backStack.add(route) },
                    onOpenDocumentation = { masweId -> backStack.add(MasweDocRoute(masweId)) }
                )
            }
            entry<Maswe0005LogRoute> {
                Maswe0005LogVulnerableScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0001StorageRoute> {
                Maswe0001StorageVulnerableScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0002StorageRoute> {
                Maswe0002StorageVulnerableScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0003StorageRoute> {
                Maswe0003StorageVulnerableScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0004StorageRoute> {
                Maswe0004StorageVulnerableScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0006StorageRoute> {
                Maswe0006StorageVulnerableScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Maswe0007CryptoRoute> { Maswe0007CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0008CryptoRoute> { Maswe0008CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0009CryptoRoute> { Maswe0009CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0010CryptoRoute> { Maswe0010CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0011CryptoRoute> { Maswe0011CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0012CryptoRoute> { Maswe0012CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0013CryptoRoute> { Maswe0013CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0014CryptoRoute> { Maswe0014CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0015CryptoRoute> { Maswe0015CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0016CryptoRoute> { Maswe0016CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0017CryptoRoute> { Maswe0017CryptoVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0018AuthRoute> { Maswe0018AuthVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0019AuthRoute> { Maswe0019AuthVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0020AuthRoute> { Maswe0020AuthVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0021AuthRoute> { Maswe0021AuthVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0022AuthRoute> { Maswe0022AuthVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0023AuthRoute> { Maswe0023AuthVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0024AuthRoute> { Maswe0024AuthVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0025AuthRoute> { Maswe0025AuthVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0026NetworkRoute> { Maswe0026NetworkVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0027NetworkRoute> { Maswe0027NetworkVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0028NetworkRoute> { Maswe0028NetworkVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0029PlatformRoute> { Maswe0029PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0030PlatformRoute> { Maswe0030PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0031PlatformRoute> { Maswe0031PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0032PlatformRoute> { Maswe0032PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0033PlatformRoute> { Maswe0033PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0034PlatformRoute> { Maswe0034PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0035PlatformRoute> { Maswe0035PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0036PlatformRoute> { Maswe0036PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0037PlatformRoute> { Maswe0037PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0038PlatformRoute> { Maswe0038PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0039PlatformRoute> { Maswe0039PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0040PlatformRoute> { Maswe0040PlatformVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0041CodeRoute> { Maswe0041CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0042CodeRoute> { Maswe0042CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0043CodeRoute> { Maswe0043CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0044CodeRoute> { Maswe0044CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0045CodeRoute> { Maswe0045CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0046CodeRoute> { Maswe0046CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0047CodeRoute> { Maswe0047CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0048CodeRoute> { Maswe0048CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0049CodeRoute> { Maswe0049CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0050CodeRoute> { Maswe0050CodeVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0051ResilienceRoute> { Maswe0051ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0052ResilienceRoute> { Maswe0052ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0053ResilienceRoute> { Maswe0053ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0054ResilienceRoute> { Maswe0054ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0055ResilienceRoute> { Maswe0055ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0056ResilienceRoute> { Maswe0056ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0057ResilienceRoute> { Maswe0057ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0058ResilienceRoute> { Maswe0058ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0059ResilienceRoute> { Maswe0059ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0060ResilienceRoute> { Maswe0060ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0061ResilienceRoute> { Maswe0061ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0062ResilienceRoute> { Maswe0062ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0063ResilienceRoute> { Maswe0063ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0064ResilienceRoute> { Maswe0064ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0065ResilienceRoute> { Maswe0065ResilienceVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0066PrivacyRoute> { Maswe0066PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0067PrivacyRoute> { Maswe0067PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0068PrivacyRoute> { Maswe0068PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0069PrivacyRoute> { Maswe0069PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0070PrivacyRoute> { Maswe0070PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0071PrivacyRoute> { Maswe0071PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0072PrivacyRoute> { Maswe0072PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0073PrivacyRoute> { Maswe0073PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0074PrivacyRoute> { Maswe0074PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0075PrivacyRoute> { Maswe0075PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0076PrivacyRoute> { Maswe0076PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0077PrivacyRoute> { Maswe0077PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
            entry<Maswe0078PrivacyRoute> { Maswe0078PrivacyVulnerableScreen(onBack = { backStack.removeLastOrNull() }) }
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
