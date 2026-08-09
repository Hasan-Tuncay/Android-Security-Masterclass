package com.hasantuncay.mobsec.common.navigation

import kotlinx.serialization.Serializable

/**
 * Navigation 3 "Keys".
 * NavDisplay uses these keys to invoke the corresponding NavEntry (Screen) contents.
 */
@Serializable data object DashboardRoute
@Serializable data object DataVaultRoute

// ── MASVS-STORAGE ────────────────────────────────────────────────────────────
@Serializable data object Maswe0001StorageRoute
@Serializable data object Maswe0002StorageRoute
@Serializable data object Maswe0003StorageRoute
@Serializable data object Maswe0004StorageRoute
@Serializable data object Maswe0005LogRoute
@Serializable data object Maswe0006StorageRoute

// ── MASVS-CRYPTO ─────────────────────────────────────────────────────────────
@Serializable data object Maswe0007CryptoRoute
@Serializable data object Maswe0008CryptoRoute
@Serializable data object Maswe0009CryptoRoute
@Serializable data object Maswe0010CryptoRoute
@Serializable data object Maswe0011CryptoRoute
@Serializable data object Maswe0012CryptoRoute
@Serializable data object Maswe0013CryptoRoute
@Serializable data object Maswe0014CryptoRoute
@Serializable data object Maswe0015CryptoRoute
@Serializable data object Maswe0016CryptoRoute
@Serializable data object Maswe0017CryptoRoute

// ── MASVS-AUTH ───────────────────────────────────────────────────────────────
@Serializable data object Maswe0018AuthRoute
@Serializable data object Maswe0019AuthRoute
@Serializable data object Maswe0020AuthRoute
@Serializable data object Maswe0021AuthRoute
@Serializable data object Maswe0022AuthRoute
@Serializable data object Maswe0023AuthRoute
@Serializable data object Maswe0024AuthRoute
@Serializable data object Maswe0025AuthRoute

// ── MASVS-NETWORK ─────────────────────────────────────────────────────────────
@Serializable data object Maswe0026NetworkRoute
@Serializable data object Maswe0027NetworkRoute
@Serializable data object Maswe0028NetworkRoute

// ── MASVS-PLATFORM ────────────────────────────────────────────────────────────
@Serializable data object Maswe0029PlatformRoute
@Serializable data object Maswe0030PlatformRoute
@Serializable data object Maswe0031PlatformRoute
@Serializable data object Maswe0032PlatformRoute
@Serializable data object Maswe0033PlatformRoute
@Serializable data object Maswe0034PlatformRoute
@Serializable data object Maswe0035PlatformRoute
@Serializable data object Maswe0036PlatformRoute
@Serializable data object Maswe0037PlatformRoute
@Serializable data object Maswe0038PlatformRoute
@Serializable data object Maswe0039PlatformRoute
@Serializable data object Maswe0040PlatformRoute

// ── MASVS-CODE ────────────────────────────────────────────────────────────────
@Serializable data object Maswe0041CodeRoute
@Serializable data object Maswe0042CodeRoute
@Serializable data object Maswe0043CodeRoute
@Serializable data object Maswe0044CodeRoute
@Serializable data object Maswe0045CodeRoute
@Serializable data object Maswe0046CodeRoute
@Serializable data object Maswe0047CodeRoute
@Serializable data object Maswe0048CodeRoute
@Serializable data object Maswe0049CodeRoute
@Serializable data object Maswe0050CodeRoute

// ── MASVS-RESILIENCE ──────────────────────────────────────────────────────────
@Serializable data object Maswe0051ResilienceRoute
@Serializable data object Maswe0052ResilienceRoute
@Serializable data object Maswe0053ResilienceRoute
@Serializable data object Maswe0054ResilienceRoute
@Serializable data object Maswe0055ResilienceRoute
@Serializable data object Maswe0056ResilienceRoute
@Serializable data object Maswe0057ResilienceRoute
@Serializable data object Maswe0058ResilienceRoute
@Serializable data object Maswe0059ResilienceRoute
@Serializable data object Maswe0060ResilienceRoute
@Serializable data object Maswe0061ResilienceRoute
@Serializable data object Maswe0062ResilienceRoute
@Serializable data object Maswe0063ResilienceRoute
@Serializable data object Maswe0064ResilienceRoute
@Serializable data object Maswe0065ResilienceRoute

@Serializable data class MasweDocRoute(val masweId: String)

// ── MASVS-PRIVACY ─────────────────────────────────────────────────────────────
@Serializable data object Maswe0066PrivacyRoute
@Serializable data object Maswe0067PrivacyRoute
@Serializable data object Maswe0068PrivacyRoute
@Serializable data object Maswe0069PrivacyRoute
@Serializable data object Maswe0070PrivacyRoute
@Serializable data object Maswe0071PrivacyRoute
@Serializable data object Maswe0072PrivacyRoute
@Serializable data object Maswe0073PrivacyRoute
@Serializable data object Maswe0074PrivacyRoute
@Serializable data object Maswe0075PrivacyRoute
@Serializable data object Maswe0076PrivacyRoute
@Serializable data object Maswe0077PrivacyRoute
@Serializable data object Maswe0078PrivacyRoute
