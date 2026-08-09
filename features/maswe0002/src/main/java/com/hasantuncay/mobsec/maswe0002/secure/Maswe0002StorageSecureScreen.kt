package com.hasantuncay.mobsec.maswe0002.secure

import com.hasantuncay.mobsec.maswe0002.R
import com.hasantuncay.mobsec.common.R as CommonR

import androidx.compose.animation.AnimatedVisibility
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Vector
import com.hasantuncay.mobsec.maswe0002.common.Maswe0002Mitigation
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0002StorageSecureScreen(
    onBack: () -> Unit,
    viewModel: Maswe0002SecureViewModel = androidx.hilt.navigation.compose.hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    BaseSecureScreen(
        meta = Maswe0002Mitigation.meta,
        vectors = Maswe0002Mitigation.entries,
        onBack = onBack,
        uiState = uiState,
        onVectorClicked = { vector ->
            viewModel.executeVector(vector = vector)
        }
    )
}
