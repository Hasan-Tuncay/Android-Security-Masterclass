package com.hasantuncay.mobsec.secure.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0026NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0027NetworkRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0028NetworkRoute
import com.hasantuncay.mobsec.maswe0026.secure.Maswe0026NetworkSecureScreen
import com.hasantuncay.mobsec.maswe0027.secure.Maswe0027NetworkSecureScreen
import com.hasantuncay.mobsec.maswe0028.secure.Maswe0028NetworkSecureScreen

/**
 * Registers all NETWORK MASWE routes.
 */
fun EntryProviderScope<Any>.registerNetworkRoutes(onBack: () -> Unit) {
        entry<Maswe0026NetworkRoute> { Maswe0026NetworkSecureScreen(onBack = onBack) }
        entry<Maswe0027NetworkRoute> { Maswe0027NetworkSecureScreen(onBack = onBack) }
        entry<Maswe0028NetworkRoute> { Maswe0028NetworkSecureScreen(onBack = onBack) }
}
