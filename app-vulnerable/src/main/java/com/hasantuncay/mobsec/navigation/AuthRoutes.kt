package com.hasantuncay.mobsec.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.maswe0018.vulnerable.Maswe0018AuthVulnerableScreen
import com.hasantuncay.mobsec.maswe0019.vulnerable.Maswe0019AuthVulnerableScreen
import com.hasantuncay.mobsec.maswe0020.vulnerable.Maswe0020AuthVulnerableScreen
import com.hasantuncay.mobsec.maswe0021.vulnerable.Maswe0021AuthVulnerableScreen
import com.hasantuncay.mobsec.maswe0022.vulnerable.Maswe0022AuthVulnerableScreen
import com.hasantuncay.mobsec.maswe0023.vulnerable.Maswe0023AuthVulnerableScreen
import com.hasantuncay.mobsec.maswe0024.vulnerable.Maswe0024AuthVulnerableScreen
import com.hasantuncay.mobsec.maswe0025.vulnerable.Maswe0025AuthVulnerableScreen
import com.hasantuncay.mobsec.common.navigation.Maswe0018AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0019AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0020AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0021AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0022AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0023AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0024AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0025AuthRoute

/**
 * Registers all AUTH MASWE routes.
 */
fun EntryProviderScope<Any>.registerAuthRoutes(onBack: () -> Unit) {
        entry<Maswe0018AuthRoute> { Maswe0018AuthVulnerableScreen(onBack = onBack) }
        entry<Maswe0019AuthRoute> { Maswe0019AuthVulnerableScreen(onBack = onBack) }
        entry<Maswe0020AuthRoute> { Maswe0020AuthVulnerableScreen(onBack = onBack) }
        entry<Maswe0021AuthRoute> { Maswe0021AuthVulnerableScreen(onBack = onBack) }
        entry<Maswe0022AuthRoute> { Maswe0022AuthVulnerableScreen(onBack = onBack) }
        entry<Maswe0023AuthRoute> { Maswe0023AuthVulnerableScreen(onBack = onBack) }
        entry<Maswe0024AuthRoute> { Maswe0024AuthVulnerableScreen(onBack = onBack) }
        entry<Maswe0025AuthRoute> { Maswe0025AuthVulnerableScreen(onBack = onBack) }
}
