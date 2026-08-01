package com.hasantuncay.mobsec.common.navigation

import kotlinx.serialization.Serializable

/**
 * Navigation 3 "Keys".
 * NavDisplay uses these keys to invoke the corresponding NavEntry (Screen) contents.
 */
@Serializable data object DashboardRoute
@Serializable data object Maswe0001LogRoute
@Serializable data object Maswe0002SharedPrefsRoute
@Serializable data object Maswe0003BackupRoute
@Serializable data object Maswe0004BackupExcludedRoute
@Serializable data object Maswe0006PrivateStorageRoute
@Serializable data object Maswe0007SharedStorageRoute
@Serializable data object DataVaultRoute
