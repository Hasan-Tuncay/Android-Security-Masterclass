package com.hasantuncay.mobsec.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0026NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0027NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0028NetworkRoute
import com.hasantuncay.mobsec.maswe0026.vulnerable.Maswe0026NetworkVulnerableScreen
import com.hasantuncay.mobsec.maswe0027.vulnerable.Maswe0027NetworkVulnerableScreen
import com.hasantuncay.mobsec.maswe0028.vulnerable.Maswe0028NetworkVulnerableScreen

/**
 * Registers all NETWORK MASWE routes.
 */
fun EntryProviderScope<Any>.registerNetworkRoutes(onBack: () -> Unit) {
        entry<Maswe0026NetworkRoute> { Maswe0026NetworkVulnerableScreen(onBack = onBack) }
        entry<Maswe0027NetworkRoute> { Maswe0027NetworkVulnerableScreen(onBack = onBack) }
        entry<Maswe0028NetworkRoute> { Maswe0028NetworkVulnerableScreen(onBack = onBack) }
}
