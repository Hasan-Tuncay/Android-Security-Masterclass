package com.hasantuncay.mobsec.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0005LogRoute
import com.hasantuncay.mobsec.maswe0005.vulnerable.Maswe0005LogVulnerableScreen

/**
 * Registers all LOG MASWE routes.
 */
fun EntryProviderScope<Any>.registerLogRoutes(onBack: () -> Unit) {
        entry<Maswe0005LogRoute> { Maswe0005LogVulnerableScreen(onBack = onBack) }
}
