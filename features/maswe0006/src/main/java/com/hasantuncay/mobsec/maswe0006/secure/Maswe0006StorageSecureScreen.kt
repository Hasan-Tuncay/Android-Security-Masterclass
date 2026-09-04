package com.hasantuncay.mobsec.maswe0006.secure

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen
import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Mitigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0006StorageSecureScreen(
    onBack: () -> Unit,
    viewModel: Maswe0006SecureViewModel = hiltViewModel()
) {
    val uiState by viewModel.legacyUiState.collectAsState()

    BaseSecureScreen(
        meta = Maswe0006Mitigation.meta,
        vectors = Maswe0006Mitigation.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { mitigation ->
            viewModel.executeVector(vector = mitigation)
        }
    )
}
