package com.hasantuncay.mobsec.maswe0002.vulnerable

import com.hasantuncay.mobsec.maswe0002.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.material3.ExperimentalMaterial3Api
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Vector
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Mitigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0002StorageVulnerableScreen(
    onBack: () -> Unit,
    viewModel: Maswe0002VulnerableViewModel = androidx.hilt.navigation.compose.hiltViewModel()
) {
    val uiState by viewModel.legacyUiState.collectAsState()
    
    BaseVulnerableScreen(
        meta = Maswe0002Vector.meta,
        vectors = Maswe0002Vector.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { vector ->
            viewModel.executeVector(vector = vector)
        }
    )
}
