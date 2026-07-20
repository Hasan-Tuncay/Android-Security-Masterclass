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
import com.hasantuncay.mobsec.common.navigation.Maswe0001LogRoute
import com.hasantuncay.mobsec.common.ui.DashboardScreen
import com.hasantuncay.mobsec.common.ui.theme.AndroidSecurityMasterclassTheme
import com.hasantuncay.mobsec.common.ui.theme.AppType
import com.hasantuncay.mobsec.common.viewmodel.MasterclassDataViewModel
import com.hasantuncay.mobsec.secure.storage.maswe0001.Maswe0001LogSecureScreen

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
                DashboardScreen(title = stringResource(R.string.dashboard_title_secure)) { route ->
                    backStack.add(route)
                }
            }
            entry<Maswe0001LogRoute> {
                Maswe0001LogSecureScreen(onBack = { backStack.removeLastOrNull() })
            }
        }
    )
}