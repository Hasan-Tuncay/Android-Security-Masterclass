package com.hasantuncay.mobsec.auditor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.hasantuncay.mobsec.common.navigation.AuditorDashboardRoute
import com.hasantuncay.mobsec.common.navigation.AuditorScreenRoute
import com.hasantuncay.mobsec.common.ui.theme.AndroidSecurityMasterclassTheme
import com.hasantuncay.mobsec.common.ui.theme.AppType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidSecurityMasterclassTheme(appType = AppType.SECURE) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AuditorApp()
                }
            }
        }
    }
}

@Composable
fun AuditorApp() {
    val context = androidx.compose.ui.platform.LocalContext.current
    val backStack = remember { mutableStateListOf<Any>(AuditorDashboardRoute) }
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
            entry<AuditorDashboardRoute> {
                AuditorDashboard(
                    onSelectMaswe = { masweId ->
                        backStack.add(AuditorScreenRoute(masweId))
                    }
                )
            }

            entry<AuditorScreenRoute> { route ->
                val viewModel: AuditorViewModel = viewModel()
                LaunchedEffect(route.masweId) {
                    viewModel.loadTree(route.masweId)
                }
                AuditorScreen(
                    viewModel = viewModel,
                    onNavigateBackToDashboard = onBack
                )
            }
        }
    )
}
