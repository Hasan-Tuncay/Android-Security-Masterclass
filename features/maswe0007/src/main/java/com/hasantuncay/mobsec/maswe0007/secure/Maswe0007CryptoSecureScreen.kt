package com.hasantuncay.mobsec.maswe0007.secure

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen
import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Mitigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0007CryptoSecureScreen(
    onBack: () -> Unit,
    viewModel: Maswe0007SecureViewModel = hiltViewModel()
) {
    val uiState by viewModel.legacyUiState.collectAsState()

    BaseSecureScreen(
        meta = Maswe0007Mitigation.meta,
        vectors = Maswe0007Mitigation.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { mitigation ->
            viewModel.executeVector(vector = mitigation)
        }
    )
}
