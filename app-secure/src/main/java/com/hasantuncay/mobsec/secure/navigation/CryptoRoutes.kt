package com.hasantuncay.mobsec.secure.navigation

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
import com.hasantuncay.mobsec.maswe0007.secure.Maswe0007CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0008.secure.Maswe0008CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0009.secure.Maswe0009CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0010.secure.Maswe0010CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0011.secure.Maswe0011CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0012.secure.Maswe0012CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0013.secure.Maswe0013CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0014.secure.Maswe0014CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0015.secure.Maswe0015CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0016.secure.Maswe0016CryptoSecureScreen
import com.hasantuncay.mobsec.maswe0017.secure.Maswe0017CryptoSecureScreen

/**
 * Registers all CRYPTO MASWE routes.
 */
fun EntryProviderScope<Any>.registerCryptoRoutes(onBack: () -> Unit) {
        entry<Maswe0007CryptoRoute> { Maswe0007CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0008CryptoRoute> { Maswe0008CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0009CryptoRoute> { Maswe0009CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0010CryptoRoute> { Maswe0010CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0011CryptoRoute> { Maswe0011CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0012CryptoRoute> { Maswe0012CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0013CryptoRoute> { Maswe0013CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0014CryptoRoute> { Maswe0014CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0015CryptoRoute> { Maswe0015CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0016CryptoRoute> { Maswe0016CryptoSecureScreen(onBack = onBack) }
        entry<Maswe0017CryptoRoute> { Maswe0017CryptoSecureScreen(onBack = onBack) }
}
