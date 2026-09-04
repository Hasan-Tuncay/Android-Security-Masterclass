package com.hasantuncay.mobsec.attacker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.compose.ui.platform.LocalContext
import android.app.Activity
import com.hasantuncay.mobsec.attacker.navigation.DashboardRoute
import com.hasantuncay.mobsec.attacker.navigation.Maswe0001ExploitRoute
import com.hasantuncay.mobsec.attacker.navigation.Maswe0002ExploitRoute
import com.hasantuncay.mobsec.attacker.navigation.Maswe0005ExploitRoute
import com.hasantuncay.mobsec.attacker.screens.DashboardScreen
import com.hasantuncay.mobsec.attacker.storage.Maswe0001ExploitScreen
import com.hasantuncay.mobsec.attacker.storage.Maswe0002ExploitScreen
import com.hasantuncay.mobsec.attacker.platform.Maswe0005ExploitScreen
import com.hasantuncay.mobsec.attacker.theme.AttackerTheme

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AttackerMainActivity : ComponentActivity() {

    private var onNewRouteListener: ((Any) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val initialRoute = parseIntentRoute(intent)

        setContent {
            AttackerTheme {
                AttackerApp(
                    initialRoute = initialRoute,
                    registerRouteListener = { listener ->
                        onNewRouteListener = listener
                    }
                )
            }
        }
    }

    override fun onNewIntent(intent: android.content.Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        val newRoute = parseIntentRoute(intent)
        onNewRouteListener?.invoke(newRoute)
    }

    private fun parseIntentRoute(intent: android.content.Intent?): Any {
        if (intent == null) return DashboardRoute
        return if (intent.action == "com.hasantuncay.mobsec.attacker.action.LOGCAT") {
            Maswe0005ExploitRoute
        } else if (intent.data != null) {
            Maswe0001ExploitRoute(
                uriString = intent.data.toString(),
                exploitId = intent.getStringExtra("exploit_id") ?: getString(R.string.exploit_id_v5),
                exploitDesc = intent.getStringExtra("exploit_description") ?: getString(R.string.exploit_title_v5)
            )
        } else {
            DashboardRoute
        }
    }
}

@Composable
fun AttackerApp(
    initialRoute: Any,
    registerRouteListener: (((Any) -> Unit) -> Unit)? = null
) {
    val context = LocalContext.current
    val maswe0001Id = stringResource(R.string.exploit_id_v5)
    val maswe0001Title = stringResource(R.string.exploit_title_v5)
    val backStack = remember { mutableStateListOf<Any>(initialRoute) }

    androidx.compose.runtime.DisposableEffect(Unit) {
        registerRouteListener?.invoke { route ->
            backStack.add(route)
        }
        onDispose { }
    }

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
                            Maswe0001ExploitRoute(
                                uriString = null,
                                exploitId = maswe0001Id,
                                exploitDesc = maswe0001Title
                            )
                        )
                    },
                    onOpenPathTraversalExploit = {
                        val payloadUri = "content://com.hasantuncay.mobsec.vulnerable.provider/download?file=../shared_prefs/maswe0001_v5_sensitive.xml"
                        backStack.add(
                            Maswe0001ExploitRoute(
                                uriString = payloadUri,
                                exploitId = "$maswe0001Id (Vector 8)",
                                exploitDesc = "Path Traversal (CWE-22)"
                            )
                        )
                    },
                    onOpenLogcatExploit = {
                        backStack.add(Maswe0005ExploitRoute)
                    },
                    onOpenExternalStorageExploit = {
                        backStack.add(Maswe0002ExploitRoute)
                    }
                )
            }
            entry<Maswe0001ExploitRoute> { route ->
                Maswe0001ExploitScreen(
                    uriString = route.uriString,
                    exploitId = route.exploitId,
                    exploitDescription = route.exploitDesc,
                    onBack = handleBack
                )
            }
            entry<Maswe0005ExploitRoute> {
                Maswe0005ExploitScreen(onBack = handleBack)
            }
            entry<Maswe0002ExploitRoute> {
                Maswe0002ExploitScreen(onBack = handleBack)
            }
        }
    )
}
