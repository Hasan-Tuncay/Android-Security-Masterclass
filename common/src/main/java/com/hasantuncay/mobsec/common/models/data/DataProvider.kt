package com.hasantuncay.mobsec.common.models.data

import androidx.compose.runtime.compositionLocalOf

/**
 * CompositionLocal providing access to the global MasterclassData across the entire Compose tree.
 * Prevents prop-drilling of sensitive dummy data to deep vulnerability screens.
 */
val LocalMasterclassData = compositionLocalOf<MasterclassData> {
    error("MasterclassData not provided! Wrap your UI with CompositionLocalProvider(LocalMasterclassData provides data).")
}
