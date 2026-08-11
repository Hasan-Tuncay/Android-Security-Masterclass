package com.hasantuncay.mobsec.maswe0003.secure

import androidx.compose.runtime.Composable
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Vector
import com.hasantuncay.mobsec.maswe0003.common.Maswe0003Mitigation
import com.hasantuncay.mobsec.maswe0003.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@Composable
fun Maswe0003StorageSecureScreen(
    onBack: () -> Unit,
    viewModel: Maswe0003SecureViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    BaseSecureScreen(
        meta = Maswe0003Mitigation.meta,
        vectors = Maswe0003Mitigation.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { mitigation ->
            viewModel.executeMitigation(mitigation)
        }
    )
}
