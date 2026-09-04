package com.hasantuncay.mobsec.maswe0006.vulnerable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen
import com.hasantuncay.mobsec.maswe0006.common.Maswe0006Vector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0006StorageVulnerableScreen(
    onBack: () -> Unit,
    viewModel: Maswe0006VulnerableViewModel = hiltViewModel()
) {
    val uiState by viewModel.legacyUiState.collectAsState()

    BaseVulnerableScreen(
        meta = Maswe0006Vector.meta,
        vectors = Maswe0006Vector.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { vector ->
            viewModel.executeVector(vector = vector)
        }
    )
}
