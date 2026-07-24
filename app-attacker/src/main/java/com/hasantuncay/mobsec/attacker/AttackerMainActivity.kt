package com.hasantuncay.mobsec.attacker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.compose.ui.platform.LocalContext
import android.app.Activity
import com.hasantuncay.mobsec.attacker.navigation.DashboardRoute
import com.hasantuncay.mobsec.attacker.navigation.ExploitReceiverRoute
import com.hasantuncay.mobsec.attacker.navigation.LogcatExploitRoute
import com.hasantuncay.mobsec.attacker.screens.DashboardScreen
import com.hasantuncay.mobsec.attacker.screens.ExploitReceiverScreen
import com.hasantuncay.mobsec.attacker.screens.LogcatExploitScreen
import com.hasantuncay.mobsec.attacker.theme.AttackerTheme

class AttackerMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Read intent data for direct routing
        val initialRoute: Any = if (intent.data != null) {
            ExploitReceiverRoute(
                uriString = intent.data.toString(),
                exploitId = intent.getStringExtra("exploit_id") ?: getString(R.string.exploit_maswe0002_id),
                exploitDesc = intent.getStringExtra("exploit_description") ?: getString(R.string.exploit_maswe0002_title)
            )
        } else {
            DashboardRoute
        }

        setContent {
            AttackerTheme {
                AttackerApp(initialRoute = initialRoute)
            }
        }
    }
}

@Composable
fun AttackerApp(initialRoute: Any) {
    val context = LocalContext.current
    val backStack = remember { mutableStateListOf<Any>(initialRoute) }

    val handleBack: () -> Unit = {
        if (backStack.size > 1) {
            backStack.removeLastOrNull()
        } else {
            (context as? Activity)?.finish()
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = handleBack,
        entryProvider = entryProvider {
            entry<DashboardRoute> {
                DashboardScreen(
                    onOpenExploitReceiver = {
                        backStack.add(
                            ExploitReceiverRoute(
                                uriString = null,
                                exploitId = context.getString(R.string.exploit_maswe0002_id),
                                exploitDesc = context.getString(R.string.exploit_maswe0002_title)
                            )
                        )
                    },
                    onOpenLogcatExploit = {
                        backStack.add(LogcatExploitRoute)
                    }
                )
            }
            entry<ExploitReceiverRoute> { route ->
                ExploitReceiverScreen(
                    uriString = route.uriString,
                    exploitId = route.exploitId,
                    exploitDescription = route.exploitDesc,
                    onBack = handleBack
                )
            }
            entry<LogcatExploitRoute> {
                LogcatExploitScreen(onBack = handleBack)
            }
        }
    )
}
