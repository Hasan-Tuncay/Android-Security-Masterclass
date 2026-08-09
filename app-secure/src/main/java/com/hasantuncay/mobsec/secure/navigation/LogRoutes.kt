package com.hasantuncay.mobsec.secure.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0005LogRoute
import com.hasantuncay.mobsec.maswe0005.secure.Maswe0005LogSecureScreen

/**
 * Registers all LOG MASWE routes.
 */
fun EntryProviderScope<Any>.registerLogRoutes(onBack: () -> Unit) {
        entry<Maswe0005LogRoute> { Maswe0005LogSecureScreen(onBack = onBack) }
}
