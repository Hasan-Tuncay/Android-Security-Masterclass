package com.hasantuncay.mobsec.common.models.data

import androidx.compose.runtime.compositionLocalOf
import com.hasantuncay.mobsec.common.viewmodel.MasterclassDataViewModel

/**
 * CompositionLocal providing access to the global MasterclassDataViewModel across the entire Compose tree.
 * Prevents prop-drilling and allows deep vulnerability screens to both read state and dispatch events.
 */
val LocalMasterclassViewModel = compositionLocalOf<MasterclassDataViewModel> {
    error("MasterclassDataViewModel not provided! Wrap your UI with CompositionLocalProvider(LocalMasterclassViewModel provides viewModel).")
}
