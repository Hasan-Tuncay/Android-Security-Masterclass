package com.hasantuncay.mobsec.secure.navigation

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
import com.hasantuncay.mobsec.maswe0066.secure.Maswe0066PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0067.secure.Maswe0067PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0068.secure.Maswe0068PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0069.secure.Maswe0069PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0070.secure.Maswe0070PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0071.secure.Maswe0071PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0072.secure.Maswe0072PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0073.secure.Maswe0073PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0074.secure.Maswe0074PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0075.secure.Maswe0075PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0076.secure.Maswe0076PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0077.secure.Maswe0077PrivacySecureScreen
import com.hasantuncay.mobsec.maswe0078.secure.Maswe0078PrivacySecureScreen

/**
 * Registers all PRIVACY MASWE routes.
 */
fun EntryProviderScope<Any>.registerPrivacyRoutes(onBack: () -> Unit) {
        entry<Maswe0066PrivacyRoute> { Maswe0066PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0067PrivacyRoute> { Maswe0067PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0068PrivacyRoute> { Maswe0068PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0069PrivacyRoute> { Maswe0069PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0070PrivacyRoute> { Maswe0070PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0071PrivacyRoute> { Maswe0071PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0072PrivacyRoute> { Maswe0072PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0073PrivacyRoute> { Maswe0073PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0074PrivacyRoute> { Maswe0074PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0075PrivacyRoute> { Maswe0075PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0076PrivacyRoute> { Maswe0076PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0077PrivacyRoute> { Maswe0077PrivacySecureScreen(onBack = onBack) }
        entry<Maswe0078PrivacyRoute> { Maswe0078PrivacySecureScreen(onBack = onBack) }
}
