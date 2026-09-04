package com.hasantuncay.mobsec.maswe0007.vulnerable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen
import com.hasantuncay.mobsec.maswe0007.common.Maswe0007Vector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0007CryptoVulnerableScreen(
    onBack: () -> Unit,
    viewModel: Maswe0007VulnerableViewModel = hiltViewModel()
) {
    val uiState by viewModel.legacyUiState.collectAsState()

    BaseVulnerableScreen(
        meta = Maswe0007Vector.meta,
        vectors = Maswe0007Vector.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { vector ->
            viewModel.executeVector(vector = vector)
        }
    )
}
