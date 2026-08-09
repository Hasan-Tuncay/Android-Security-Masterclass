package com.hasantuncay.mobsec.secure.storage.maswe0002

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.hasantuncay.mobsec.common.models.Maswe0002Mitigation
import com.hasantuncay.mobsec.common.models.data.LocalMasterclassViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseSecureScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0002StorageSecureScreen(onBack: () -> Unit) {
    val viewModel = LocalMasterclassViewModel.current
    val appData by viewModel.masterclassData.collectAsState()
    val context = LocalContext.current

    BaseSecureScreen(
        vectors = Maswe0002Mitigation.entries,
        onBack = onBack,
        onVectorClicked = { vector ->
            var path: String? = null
            Maswe0002SecureLogic.executeVector(
                vector = vector,
                appData = appData,
                context = context,
                onResult = { path = it }
            )
            path
        }
    )
}
