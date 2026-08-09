package com.hasantuncay.mobsec.secure.navigation

import androidx.navigation3.runtime.EntryProviderScope
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
import com.hasantuncay.mobsec.maswe0041.secure.Maswe0041CodeSecureScreen
import com.hasantuncay.mobsec.maswe0042.secure.Maswe0042CodeSecureScreen
import com.hasantuncay.mobsec.maswe0043.secure.Maswe0043CodeSecureScreen
import com.hasantuncay.mobsec.maswe0044.secure.Maswe0044CodeSecureScreen
import com.hasantuncay.mobsec.maswe0045.secure.Maswe0045CodeSecureScreen
import com.hasantuncay.mobsec.maswe0046.secure.Maswe0046CodeSecureScreen
import com.hasantuncay.mobsec.maswe0047.secure.Maswe0047CodeSecureScreen
import com.hasantuncay.mobsec.maswe0048.secure.Maswe0048CodeSecureScreen
import com.hasantuncay.mobsec.maswe0049.secure.Maswe0049CodeSecureScreen
import com.hasantuncay.mobsec.maswe0050.secure.Maswe0050CodeSecureScreen

/**
 * Registers all CODE MASWE routes.
 */
fun EntryProviderScope<Any>.registerCodeRoutes(onBack: () -> Unit) {
        entry<Maswe0041CodeRoute> { Maswe0041CodeSecureScreen(onBack = onBack) }
        entry<Maswe0042CodeRoute> { Maswe0042CodeSecureScreen(onBack = onBack) }
        entry<Maswe0043CodeRoute> { Maswe0043CodeSecureScreen(onBack = onBack) }
        entry<Maswe0044CodeRoute> { Maswe0044CodeSecureScreen(onBack = onBack) }
        entry<Maswe0045CodeRoute> { Maswe0045CodeSecureScreen(onBack = onBack) }
        entry<Maswe0046CodeRoute> { Maswe0046CodeSecureScreen(onBack = onBack) }
        entry<Maswe0047CodeRoute> { Maswe0047CodeSecureScreen(onBack = onBack) }
        entry<Maswe0048CodeRoute> { Maswe0048CodeSecureScreen(onBack = onBack) }
        entry<Maswe0049CodeRoute> { Maswe0049CodeSecureScreen(onBack = onBack) }
        entry<Maswe0050CodeRoute> { Maswe0050CodeSecureScreen(onBack = onBack) }
}
