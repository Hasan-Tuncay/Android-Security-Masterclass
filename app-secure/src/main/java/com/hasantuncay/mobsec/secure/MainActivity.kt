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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.hasantuncay.mobsec.common.R

import com.hasantuncay.mobsec.common.navigation.DashboardRoute
import com.hasantuncay.mobsec.common.navigation.DataVaultRoute
import com.hasantuncay.mobsec.common.navigation.MasweDocRoute
import com.hasantuncay.mobsec.common.ui.DashboardScreen
import com.hasantuncay.mobsec.common.ui.DataVaultScreen
import com.hasantuncay.mobsec.common.ui.MasweDocScreen
import com.hasantuncay.mobsec.common.ui.theme.AndroidSecurityMasterclassTheme
import com.hasantuncay.mobsec.common.ui.theme.AppType

import com.hasantuncay.mobsec.secure.navigation.*

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidSecurityMasterclassTheme(appType = AppType.SECURE) {
                SecureApp()
            }
        }
    }
}

@Composable
fun SecureApp() {
    val context = androidx.compose.ui.platform.LocalContext.current
    val backStack = remember { mutableStateListOf<Any>(DashboardRoute) }
    val onBack: () -> Unit = {
        if (backStack.size > 1) {
            backStack.removeLastOrNull()
        } else {
            (context as? android.app.Activity)?.finish()
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = onBack,
        entryProvider = entryProvider {
            entry<DashboardRoute> {
                DashboardScreen(
                    title = stringResource(R.string.dashboard_title_secure),
                    onNavigate = { route -> backStack.add(route) },
                    onOpenDocumentation = { masweId -> backStack.add(MasweDocRoute(masweId)) }
                )
            }

            // ── Category Routes (auto-registered) ──
            registerStorageRoutes(onBack)
            registerLogRoutes(onBack)
            registerCryptoRoutes(onBack)
            registerAuthRoutes(onBack)
            registerNetworkRoutes(onBack)
            registerPlatformRoutes(onBack)
            registerCodeRoutes(onBack)
            registerResilienceRoutes(onBack)
            registerPrivacyRoutes(onBack)

            // ── Utility Routes ──
            entry<MasweDocRoute> { route ->
                MasweDocScreen(masweId = route.masweId, onBack = onBack)
            }
            entry<DataVaultRoute> {
                DataVaultScreen(onBack = onBack)
            }
        }
    )
}
