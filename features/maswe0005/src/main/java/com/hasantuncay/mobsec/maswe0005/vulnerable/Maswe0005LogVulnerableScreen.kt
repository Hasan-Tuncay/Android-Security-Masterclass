package com.hasantuncay.mobsec.maswe0005.vulnerable

import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Vector
import com.hasantuncay.mobsec.maswe0005.common.Maswe0005Mitigation
import com.hasantuncay.mobsec.maswe0005.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0005LogVulnerableScreen(
    onBack: () -> Unit,
    viewModel: Maswe0005VulnerableViewModel = androidx.hilt.navigation.compose.hiltViewModel()
) {
    val uiState by viewModel.legacyUiState.collectAsState()
    
    BaseVulnerableScreen(
        meta = Maswe0005Vector.meta,
        vectors = Maswe0005Vector.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { vector ->
            viewModel.executeVector(vector = vector)
        }
    )
}
