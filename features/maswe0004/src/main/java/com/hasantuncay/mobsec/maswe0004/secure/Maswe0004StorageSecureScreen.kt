package com.hasantuncay.mobsec.maswe0004.secure

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Mitigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0004StorageSecureScreen(
    onBack: () -> Unit,
    viewModel: Maswe0004SecureViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    BaseSecureScreen(
        meta = Maswe0004Mitigation.meta,
        vectors = Maswe0004Mitigation.entries,
        onBack = onBack,
        uiState = state.executionState,
        onVectorClicked = { vector ->
            viewModel.processIntent(Maswe0004SecureIntent.ExecuteMitigation(vector))
        }
    )
}
