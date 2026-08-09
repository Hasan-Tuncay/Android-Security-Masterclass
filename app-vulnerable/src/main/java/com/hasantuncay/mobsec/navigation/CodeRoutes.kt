package com.hasantuncay.mobsec.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.maswe0041.vulnerable.Maswe0041CodeVulnerableScreen
import com.hasantuncay.mobsec.maswe0042.vulnerable.Maswe0042CodeVulnerableScreen
import com.hasantuncay.mobsec.maswe0043.vulnerable.Maswe0043CodeVulnerableScreen
import com.hasantuncay.mobsec.maswe0044.vulnerable.Maswe0044CodeVulnerableScreen
import com.hasantuncay.mobsec.maswe0045.vulnerable.Maswe0045CodeVulnerableScreen
import com.hasantuncay.mobsec.maswe0046.vulnerable.Maswe0046CodeVulnerableScreen
import com.hasantuncay.mobsec.maswe0047.vulnerable.Maswe0047CodeVulnerableScreen
import com.hasantuncay.mobsec.maswe0048.vulnerable.Maswe0048CodeVulnerableScreen
import com.hasantuncay.mobsec.maswe0049.vulnerable.Maswe0049CodeVulnerableScreen
import com.hasantuncay.mobsec.maswe0050.vulnerable.Maswe0050CodeVulnerableScreen
import com.hasantuncay.mobsec.common.navigation.Maswe0041CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0042CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0043CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0044CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0045CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0046CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0047CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0048CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0049CodeRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0050CodeRoute

/**
 * Registers all CODE MASWE routes.
 */
fun EntryProviderScope<Any>.registerCodeRoutes(onBack: () -> Unit) {
        entry<Maswe0041CodeRoute> { Maswe0041CodeVulnerableScreen(onBack = onBack) }
        entry<Maswe0042CodeRoute> { Maswe0042CodeVulnerableScreen(onBack = onBack) }
        entry<Maswe0043CodeRoute> { Maswe0043CodeVulnerableScreen(onBack = onBack) }
        entry<Maswe0044CodeRoute> { Maswe0044CodeVulnerableScreen(onBack = onBack) }
        entry<Maswe0045CodeRoute> { Maswe0045CodeVulnerableScreen(onBack = onBack) }
        entry<Maswe0046CodeRoute> { Maswe0046CodeVulnerableScreen(onBack = onBack) }
        entry<Maswe0047CodeRoute> { Maswe0047CodeVulnerableScreen(onBack = onBack) }
        entry<Maswe0048CodeRoute> { Maswe0048CodeVulnerableScreen(onBack = onBack) }
        entry<Maswe0049CodeRoute> { Maswe0049CodeVulnerableScreen(onBack = onBack) }
        entry<Maswe0050CodeRoute> { Maswe0050CodeVulnerableScreen(onBack = onBack) }
}
