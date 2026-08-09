package com.hasantuncay.mobsec.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0001StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0002StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0003StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0004StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0006StorageRoute
import com.hasantuncay.mobsec.maswe0001.vulnerable.Maswe0001StorageVulnerableScreen
import com.hasantuncay.mobsec.maswe0002.vulnerable.Maswe0002StorageVulnerableScreen
import com.hasantuncay.mobsec.maswe0003.vulnerable.Maswe0003StorageVulnerableScreen
import com.hasantuncay.mobsec.maswe0004.vulnerable.Maswe0004StorageVulnerableScreen
import com.hasantuncay.mobsec.maswe0006.vulnerable.Maswe0006StorageVulnerableScreen

/**
 * Registers all STORAGE MASWE routes.
 */
fun EntryProviderScope<Any>.registerStorageRoutes(onBack: () -> Unit) {
        entry<Maswe0001StorageRoute> { Maswe0001StorageVulnerableScreen(onBack = onBack) }
        entry<Maswe0002StorageRoute> { Maswe0002StorageVulnerableScreen(onBack = onBack) }
        entry<Maswe0003StorageRoute> { Maswe0003StorageVulnerableScreen(onBack = onBack) }
        entry<Maswe0004StorageRoute> { Maswe0004StorageVulnerableScreen(onBack = onBack) }
        entry<Maswe0006StorageRoute> { Maswe0006StorageVulnerableScreen(onBack = onBack) }
}
