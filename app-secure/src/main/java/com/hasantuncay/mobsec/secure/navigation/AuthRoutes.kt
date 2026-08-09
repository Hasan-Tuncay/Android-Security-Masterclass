package com.hasantuncay.mobsec.secure.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.hasantuncay.mobsec.common.navigation.Maswe0018AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0019AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0020AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0021AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0022AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0023AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0024AuthRoute
import com.hasantuncay.mobsec.common.navigation.Maswe0025AuthRoute
import com.hasantuncay.mobsec.maswe0018.secure.Maswe0018AuthSecureScreen
import com.hasantuncay.mobsec.maswe0019.secure.Maswe0019AuthSecureScreen
import com.hasantuncay.mobsec.maswe0020.secure.Maswe0020AuthSecureScreen
import com.hasantuncay.mobsec.maswe0021.secure.Maswe0021AuthSecureScreen
import com.hasantuncay.mobsec.maswe0022.secure.Maswe0022AuthSecureScreen
import com.hasantuncay.mobsec.maswe0023.secure.Maswe0023AuthSecureScreen
import com.hasantuncay.mobsec.maswe0024.secure.Maswe0024AuthSecureScreen
import com.hasantuncay.mobsec.maswe0025.secure.Maswe0025AuthSecureScreen

/**
 * Registers all AUTH MASWE routes.
 */
fun EntryProviderScope<Any>.registerAuthRoutes(onBack: () -> Unit) {
        entry<Maswe0018AuthRoute> { Maswe0018AuthSecureScreen(onBack = onBack) }
        entry<Maswe0019AuthRoute> { Maswe0019AuthSecureScreen(onBack = onBack) }
        entry<Maswe0020AuthRoute> { Maswe0020AuthSecureScreen(onBack = onBack) }
        entry<Maswe0021AuthRoute> { Maswe0021AuthSecureScreen(onBack = onBack) }
        entry<Maswe0022AuthRoute> { Maswe0022AuthSecureScreen(onBack = onBack) }
        entry<Maswe0023AuthRoute> { Maswe0023AuthSecureScreen(onBack = onBack) }
        entry<Maswe0024AuthRoute> { Maswe0024AuthSecureScreen(onBack = onBack) }
        entry<Maswe0025AuthRoute> { Maswe0025AuthSecureScreen(onBack = onBack) }
}
