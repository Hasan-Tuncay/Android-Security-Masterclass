package com.hasantuncay.mobsec.secure.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0029PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0030PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0031PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0032PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0033PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0034PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0035PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0036PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0037PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0038PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0039PlatformRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0040PlatformRoute
import com.hasantuncay.mobsec.maswe0029.secure.Maswe0029PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0030.secure.Maswe0030PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0031.secure.Maswe0031PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0032.secure.Maswe0032PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0033.secure.Maswe0033PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0034.secure.Maswe0034PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0035.secure.Maswe0035PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0036.secure.Maswe0036PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0037.secure.Maswe0037PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0038.secure.Maswe0038PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0039.secure.Maswe0039PlatformSecureScreen
import com.hasantuncay.mobsec.maswe0040.secure.Maswe0040PlatformSecureScreen

/**
 * Registers all PLATFORM MASWE routes.
 */
fun EntryProviderScope<Any>.registerPlatformRoutes(onBack: () -> Unit) {
        entry<Maswe0029PlatformRoute> { Maswe0029PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0030PlatformRoute> { Maswe0030PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0031PlatformRoute> { Maswe0031PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0032PlatformRoute> { Maswe0032PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0033PlatformRoute> { Maswe0033PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0034PlatformRoute> { Maswe0034PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0035PlatformRoute> { Maswe0035PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0036PlatformRoute> { Maswe0036PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0037PlatformRoute> { Maswe0037PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0038PlatformRoute> { Maswe0038PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0039PlatformRoute> { Maswe0039PlatformSecureScreen(onBack = onBack) }
        entry<Maswe0040PlatformRoute> { Maswe0040PlatformSecureScreen(onBack = onBack) }
}
