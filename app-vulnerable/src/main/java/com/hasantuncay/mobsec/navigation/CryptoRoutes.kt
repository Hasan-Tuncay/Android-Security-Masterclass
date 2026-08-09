package com.hasantuncay.mobsec.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0007CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0008CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0009CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0010CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0011CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0012CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0013CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0014CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0015CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0016CryptoRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0017CryptoRoute
import com.hasantuncay.mobsec.maswe0007.vulnerable.Maswe0007CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0008.vulnerable.Maswe0008CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0009.vulnerable.Maswe0009CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0010.vulnerable.Maswe0010CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0011.vulnerable.Maswe0011CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0012.vulnerable.Maswe0012CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0013.vulnerable.Maswe0013CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0014.vulnerable.Maswe0014CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0015.vulnerable.Maswe0015CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0016.vulnerable.Maswe0016CryptoVulnerableScreen
import com.hasantuncay.mobsec.maswe0017.vulnerable.Maswe0017CryptoVulnerableScreen

/**
 * Registers all CRYPTO MASWE routes.
 */
fun EntryProviderScope<Any>.registerCryptoRoutes(onBack: () -> Unit) {
        entry<Maswe0007CryptoRoute> { Maswe0007CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0008CryptoRoute> { Maswe0008CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0009CryptoRoute> { Maswe0009CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0010CryptoRoute> { Maswe0010CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0011CryptoRoute> { Maswe0011CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0012CryptoRoute> { Maswe0012CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0013CryptoRoute> { Maswe0013CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0014CryptoRoute> { Maswe0014CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0015CryptoRoute> { Maswe0015CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0016CryptoRoute> { Maswe0016CryptoVulnerableScreen(onBack = onBack) }
        entry<Maswe0017CryptoRoute> { Maswe0017CryptoVulnerableScreen(onBack = onBack) }
}
