package com.hasantuncay.mobsec.maswe0001.vulnerable

import com.hasantuncay.mobsec.maswe0001.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.maswe0001.common.Maswe0001Vector
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0001StorageVulnerableScreen(
    onBack: () -> Unit,
    viewModel: Maswe0001VulnerableViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    BaseVulnerableScreen(
        meta = Maswe0001Vector.meta,
        vectors = Maswe0001Vector.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { vector ->
            viewModel.executeVector(vector = vector)
        }
    )
}
