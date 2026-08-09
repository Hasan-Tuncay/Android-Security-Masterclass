package com.hasantuncay.mobsec.secure.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0001StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0002StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0003StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0004StorageRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0006StorageRoute
import com.hasantuncay.mobsec.maswe0001.secure.Maswe0001StorageSecureScreen
import com.hasantuncay.mobsec.maswe0002.secure.Maswe0002StorageSecureScreen
import com.hasantuncay.mobsec.maswe0003.secure.Maswe0003StorageSecureScreen
import com.hasantuncay.mobsec.maswe0004.secure.Maswe0004StorageSecureScreen
import com.hasantuncay.mobsec.maswe0006.secure.Maswe0006StorageSecureScreen

/**
 * Registers all STORAGE MASWE routes.
 */
fun EntryProviderScope<Any>.registerStorageRoutes(onBack: () -> Unit) {
        entry<Maswe0001StorageRoute> { Maswe0001StorageSecureScreen(onBack = onBack) }
        entry<Maswe0002StorageRoute> { Maswe0002StorageSecureScreen(onBack = onBack) }
        entry<Maswe0003StorageRoute> { Maswe0003StorageSecureScreen(onBack = onBack) }
        entry<Maswe0004StorageRoute> { Maswe0004StorageSecureScreen(onBack = onBack) }
        entry<Maswe0006StorageRoute> { Maswe0006StorageSecureScreen(onBack = onBack) }
}
