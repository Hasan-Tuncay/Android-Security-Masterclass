package com.hasantuncay.mobsec.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0066PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0067PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0068PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0069PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0070PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0071PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0072PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0073PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0074PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0075PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0076PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0077PrivacyRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0078PrivacyRoute
import com.hasantuncay.mobsec.maswe0066.vulnerable.Maswe0066PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0067.vulnerable.Maswe0067PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0068.vulnerable.Maswe0068PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0069.vulnerable.Maswe0069PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0070.vulnerable.Maswe0070PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0071.vulnerable.Maswe0071PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0072.vulnerable.Maswe0072PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0073.vulnerable.Maswe0073PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0074.vulnerable.Maswe0074PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0075.vulnerable.Maswe0075PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0076.vulnerable.Maswe0076PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0077.vulnerable.Maswe0077PrivacyVulnerableScreen
import com.hasantuncay.mobsec.maswe0078.vulnerable.Maswe0078PrivacyVulnerableScreen

/**
 * Registers all PRIVACY MASWE routes.
 */
fun EntryProviderScope<Any>.registerPrivacyRoutes(onBack: () -> Unit) {
        entry<Maswe0066PrivacyRoute> { Maswe0066PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0067PrivacyRoute> { Maswe0067PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0068PrivacyRoute> { Maswe0068PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0069PrivacyRoute> { Maswe0069PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0070PrivacyRoute> { Maswe0070PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0071PrivacyRoute> { Maswe0071PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0072PrivacyRoute> { Maswe0072PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0073PrivacyRoute> { Maswe0073PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0074PrivacyRoute> { Maswe0074PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0075PrivacyRoute> { Maswe0075PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0076PrivacyRoute> { Maswe0076PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0077PrivacyRoute> { Maswe0077PrivacyVulnerableScreen(onBack = onBack) }
        entry<Maswe0078PrivacyRoute> { Maswe0078PrivacyVulnerableScreen(onBack = onBack) }
}
