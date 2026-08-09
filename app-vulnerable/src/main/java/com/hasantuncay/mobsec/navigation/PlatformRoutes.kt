package com.hasantuncay.mobsec.navigation

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
import com.hasantuncay.mobsec.maswe0029.vulnerable.Maswe0029PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0030.vulnerable.Maswe0030PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0031.vulnerable.Maswe0031PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0032.vulnerable.Maswe0032PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0033.vulnerable.Maswe0033PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0034.vulnerable.Maswe0034PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0035.vulnerable.Maswe0035PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0036.vulnerable.Maswe0036PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0037.vulnerable.Maswe0037PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0038.vulnerable.Maswe0038PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0039.vulnerable.Maswe0039PlatformVulnerableScreen
import com.hasantuncay.mobsec.maswe0040.vulnerable.Maswe0040PlatformVulnerableScreen

/**
 * Registers all PLATFORM MASWE routes.
 */
fun EntryProviderScope<Any>.registerPlatformRoutes(onBack: () -> Unit) {
        entry<Maswe0029PlatformRoute> { Maswe0029PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0030PlatformRoute> { Maswe0030PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0031PlatformRoute> { Maswe0031PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0032PlatformRoute> { Maswe0032PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0033PlatformRoute> { Maswe0033PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0034PlatformRoute> { Maswe0034PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0035PlatformRoute> { Maswe0035PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0036PlatformRoute> { Maswe0036PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0037PlatformRoute> { Maswe0037PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0038PlatformRoute> { Maswe0038PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0039PlatformRoute> { Maswe0039PlatformVulnerableScreen(onBack = onBack) }
        entry<Maswe0040PlatformRoute> { Maswe0040PlatformVulnerableScreen(onBack = onBack) }
}
