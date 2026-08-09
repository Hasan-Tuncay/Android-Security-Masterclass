package com.hasantuncay.mobsec.secure.navigation

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
import com.hasantuncay.mobsec.maswe0051.secure.Maswe0051ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0052.secure.Maswe0052ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0053.secure.Maswe0053ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0054.secure.Maswe0054ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0055.secure.Maswe0055ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0056.secure.Maswe0056ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0057.secure.Maswe0057ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0058.secure.Maswe0058ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0059.secure.Maswe0059ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0060.secure.Maswe0060ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0061.secure.Maswe0061ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0062.secure.Maswe0062ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0063.secure.Maswe0063ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0064.secure.Maswe0064ResilienceSecureScreen
import com.hasantuncay.mobsec.maswe0065.secure.Maswe0065ResilienceSecureScreen

/**
 * Registers all RESILIENCE MASWE routes.
 */
fun EntryProviderScope<Any>.registerResilienceRoutes(onBack: () -> Unit) {
        entry<Maswe0051ResilienceRoute> { Maswe0051ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0052ResilienceRoute> { Maswe0052ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0053ResilienceRoute> { Maswe0053ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0054ResilienceRoute> { Maswe0054ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0055ResilienceRoute> { Maswe0055ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0056ResilienceRoute> { Maswe0056ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0057ResilienceRoute> { Maswe0057ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0058ResilienceRoute> { Maswe0058ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0059ResilienceRoute> { Maswe0059ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0060ResilienceRoute> { Maswe0060ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0061ResilienceRoute> { Maswe0061ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0062ResilienceRoute> { Maswe0062ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0063ResilienceRoute> { Maswe0063ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0064ResilienceRoute> { Maswe0064ResilienceSecureScreen(onBack = onBack) }
        entry<Maswe0065ResilienceRoute> { Maswe0065ResilienceSecureScreen(onBack = onBack) }
}
