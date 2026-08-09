package com.hasantuncay.mobsec.maswe0001.secure

import com.hasantuncay.mobsec.maswe0001.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.maswe0001.common.Maswe0001Mitigation
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0001StorageSecureScreen(
    onBack: () -> Unit,
    viewModel: Maswe0001SecureViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    BaseSecureScreen(
        meta = Maswe0001Mitigation.meta,
        vectors = Maswe0001Mitigation.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { vector ->
            viewModel.executeVector(vector = vector)
        }
    )
}
