package com.hasantuncay.mobsec.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0051ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0052ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0053ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0054ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0055ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0056ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0057ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0058ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0059ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0060ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0061ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0062ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0063ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0064ResilienceRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0065ResilienceRoute
import com.hasantuncay.mobsec.maswe0051.vulnerable.Maswe0051ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0052.vulnerable.Maswe0052ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0053.vulnerable.Maswe0053ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0054.vulnerable.Maswe0054ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0055.vulnerable.Maswe0055ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0056.vulnerable.Maswe0056ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0057.vulnerable.Maswe0057ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0058.vulnerable.Maswe0058ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0059.vulnerable.Maswe0059ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0060.vulnerable.Maswe0060ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0061.vulnerable.Maswe0061ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0062.vulnerable.Maswe0062ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0063.vulnerable.Maswe0063ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0064.vulnerable.Maswe0064ResilienceVulnerableScreen
import com.hasantuncay.mobsec.maswe0065.vulnerable.Maswe0065ResilienceVulnerableScreen

/**
 * Registers all RESILIENCE MASWE routes.
 */
fun EntryProviderScope<Any>.registerResilienceRoutes(onBack: () -> Unit) {
        entry<Maswe0051ResilienceRoute> { Maswe0051ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0052ResilienceRoute> { Maswe0052ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0053ResilienceRoute> { Maswe0053ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0054ResilienceRoute> { Maswe0054ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0055ResilienceRoute> { Maswe0055ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0056ResilienceRoute> { Maswe0056ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0057ResilienceRoute> { Maswe0057ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0058ResilienceRoute> { Maswe0058ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0059ResilienceRoute> { Maswe0059ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0060ResilienceRoute> { Maswe0060ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0061ResilienceRoute> { Maswe0061ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0062ResilienceRoute> { Maswe0062ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0063ResilienceRoute> { Maswe0063ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0064ResilienceRoute> { Maswe0064ResilienceVulnerableScreen(onBack = onBack) }
        entry<Maswe0065ResilienceRoute> { Maswe0065ResilienceVulnerableScreen(onBack = onBack) }
}
