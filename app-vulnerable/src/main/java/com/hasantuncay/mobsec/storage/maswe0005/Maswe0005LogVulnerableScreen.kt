package com.hasantuncay.mobsec.storage.maswe0005

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.hasantuncay.mobsec.common.models.Maswe0005Vector
import com.hasantuncay.mobsec.common.models.data.LocalMasterclassViewModel
import com.hasantuncay.mobsec.common.ui.components.BaseVulnerableScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Maswe0005LogVulnerableScreen(onBack: () -> Unit) {
    val viewModel = LocalMasterclassViewModel.current
    val appData by viewModel.masterclassData.collectAsState()
    val context = LocalContext.current

    BaseVulnerableScreen(
        vectors = Maswe0005Vector.entries,
        onBack = onBack,
        onVectorClicked = { vector ->
            var path: String? = null
            Maswe0005VulnerableLogic.executeVector(
                vector = vector,
                appData = appData,
                context = context,
                onResult = { path = it }
            )
            path
        }
    )
}
