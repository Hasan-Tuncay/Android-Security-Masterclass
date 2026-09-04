package com.hasantuncay.mobsec.maswe0004.vulnerable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen
import com.hasantuncay.mobsec.maswe0004.common.Maswe0004Vector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0004StorageVulnerableScreen(
    onBack: () -> Unit,
    viewModel: Maswe0004VulnerableViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    BaseVulnerableScreen(
        meta = Maswe0004Vector.meta,
        vectors = Maswe0004Vector.entries,
        onBack = onBack,
        uiState = state.executionState,
        onVectorClicked = { vector ->
            viewModel.processIntent(Maswe0004VulnerableIntent.ExecuteVector(vector))
        }
    )
}
